package com.mobius.pbl.receiver

/**
 * @file ItemBroadcastContract.kt
 * @brief 외부 Intent/Broadcast 요청에서 사용할 action/extras 키를 정의합니다.
 */
object ItemBroadcastContract {
    const val ACTION_ADD: String = "com.mobius.pbl.ACTION_ADD"
    const val ACTION_DELETE: String = "com.mobius.pbl.ACTION_DELETE"
    const val ACTION_SET_FLAG: String = "com.mobius.pbl.ACTION_SET_FLAG"

    const val EXTRA_TITLE: String = "title"
    const val EXTRA_ITEM_ID: String = "itemId"
    const val EXTRA_FLAG: String = "flag"
}

