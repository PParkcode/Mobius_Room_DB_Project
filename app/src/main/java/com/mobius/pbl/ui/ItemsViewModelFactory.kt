package com.mobius.pbl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobius.pbl.data.ItemRepository

/**
 * @file ItemsViewModelFactory.kt
 * @fn ItemsViewModelFactory
 * @brief ViewModel에 Repository를 주입하기 위한 Factory 입니다.
 */
class ItemsViewModelFactory(
    private val repository: ItemRepository,
) : ViewModelProvider.Factory {

    /**
     * @brief ViewModel 인스턴스를 생성합니다.
     * @param modelClass 생성 대상 ViewModel 클래스
     * @return 생성된 ViewModel
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
    }
}

