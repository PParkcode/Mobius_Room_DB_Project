package com.mobius.pbl.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.mobius.pbl.data.AppDatabaseProvider
import com.mobius.pbl.data.ItemRepository
import com.mobius.pbl.ui.theme.MobiusPblTheme

/**
 * @file MainActivity.kt
 * @fn MainActivity
 * @brief 앱의 엔트리 포인트 Activity 입니다. Compose UI를 표시합니다.
 */
class MainActivity : ComponentActivity() {
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

