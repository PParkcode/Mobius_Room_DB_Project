package com.mobius.pbl.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.mobius.pbl.data.AppDatabaseProvider
import com.mobius.pbl.data.ItemRepository
import com.mobius.pbl.ui.theme.MobiusPblTheme

/**
 * @file MainActivity.kt
 * @fn MainActivity
 * @brief 앱의 엔트리 포인트 Activity 입니다. Compose UI를 표시합니다.
 * @date 2026-03-23
 * @author Gemini
 */
class MainActivity : ComponentActivity() {
    /**
     * @brief Activity가 생성될 때 호출되며, UI를 설정하고 ViewModel을 초기화합니다.
     * @param savedInstanceState 이전에 저장된 상태가 있는 경우 전달되는 Bundle
     * @date 2026-03-23
     * @author Gemini
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabaseProvider.get(applicationContext)
        val repository = ItemRepository(db.itemDao())
        val viewModel = ViewModelProvider(
            this,
            ItemsViewModelFactory(repository)
        )[ItemsViewModel::class.java]

        setContent {
            MobiusPblTheme {
                ItemsScreen(viewModel = viewModel)
            }
        }
    }
}
