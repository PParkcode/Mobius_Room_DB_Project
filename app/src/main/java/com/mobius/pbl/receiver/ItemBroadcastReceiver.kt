package com.mobius.pbl.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.mobius.pbl.data.AppDatabaseProvider
import com.mobius.pbl.data.ItemRepository
import com.mobius.pbl.domain.TitleValidator
import com.mobius.pbl.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * @file ItemBroadcastReceiver.kt
 * @fn ItemBroadcastReceiver
 * @brief 외부 Broadcast 요청을 받아 Room에 반영하는 Receiver입니다.
 */
class ItemBroadcastReceiver : BroadcastReceiver() {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action == null) {
            showToast(context)
            return
        }

        val pending = goAsync()
        scope.launch {
            try {
                when (action) {
                    ItemBroadcastContract.ACTION_ADD -> handleAdd(context, intent)
                    ItemBroadcastContract.ACTION_DELETE -> handleDelete(context, intent)
                    ItemBroadcastContract.ACTION_SET_FLAG -> handleSetFlag(context, intent)
                    else -> showToast(context)
                }
            } finally {
                pending.finish()
            }
        }
    }

    /**
     * @brief 외부 요청으로 새 아이템을 추가합니다.
     */
    private suspend fun handleAdd(context: Context, intent: Intent) {
        val rawTitle = intent.getStringExtra(ItemBroadcastContract.EXTRA_TITLE)
        if (!TitleValidator.isValid(rawTitle)) {
            showToast(context)
            return
        }

        val title = rawTitle!!.trim()
        val repo = ItemRepository(AppDatabaseProvider.get(context).itemDao())
        repo.add(title = title)
    }

    /**
     * @brief 외부 요청으로 특정 아이템을 삭제합니다.
     */
    private suspend fun handleDelete(context: Context, intent: Intent) {
        val itemId = intent.getIntExtra(ItemBroadcastContract.EXTRA_ITEM_ID, -1)
        if (itemId <= 0) {
            showToast(context)
            return
        }

        val repo = ItemRepository(AppDatabaseProvider.get(context).itemDao())
        repo.deleteById(id = itemId)
    }

    /**
     * @brief 외부 요청으로 특정 아이템의 flag 값을 설정합니다.
     */
    private suspend fun handleSetFlag(context: Context, intent: Intent) {
        if (!intent.hasExtra(ItemBroadcastContract.EXTRA_ITEM_ID) ||
            !intent.hasExtra(ItemBroadcastContract.EXTRA_FLAG)
        ) {
            showToast(context)
            return
        }

        val itemId = intent.getIntExtra(ItemBroadcastContract.EXTRA_ITEM_ID, -1)
        val flag = intent.getBooleanExtra(ItemBroadcastContract.EXTRA_FLAG, false)
        if (itemId <= 0) {
            showToast(context)
            return
        }

        val repo = ItemRepository(AppDatabaseProvider.get(context).itemDao())
        repo.setFlag(id = itemId, flag = flag)
    }

    /**
     * @brief invalid 요청에 대해 동일한 토스트 메시지를 표시합니다.
     */
    private fun showToast(context: Context) {
        Toast.makeText(
            context,
            context.getString(R.string.invalid_request_message),
            Toast.LENGTH_SHORT
        ).show()
    }
}

