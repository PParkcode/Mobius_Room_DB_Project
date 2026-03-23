package com.mobius.pbl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobius.pbl.data.ItemRepository
import com.mobius.pbl.domain.TitleValidator
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * @file ItemsViewModel.kt
 * @fn ItemsViewModel
 * @brief UI에서 아이템 목록/조작을 처리하는 ViewModel 입니다.
 */
class ItemsViewModel(
    private val repository: ItemRepository,
) : ViewModel() {

    /**
     * @brief Room 변경 사항을 observe하여 Compose에서 바로 사용할 수 있는 StateFlow 입니다.
     * @return 아이템 리스트 StateFlow
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    val items: StateFlow<List<com.mobius.pbl.data.ItemEntity>> =
        repository.items.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    /**
     * @brief 입력 title이 유효하면 DB에 새 아이템을 추가합니다.
     * @param rawTitle 입력 문자열
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    fun addTitle(rawTitle: String) {
        val title = rawTitle.trim()
        if (!TitleValidator.isValid(title)) return

        viewModelScope.launch {
            repository.add(title)
        }
    }

    /**
     * @brief 아이템을 삭제합니다.
     * @param itemId 삭제할 아이템 id
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    fun deleteItem(itemId: Int) {
        if (itemId <= 0) return

        viewModelScope.launch {
            repository.deleteById(itemId)
        }
    }

    /**
     * @brief 특정 아이템의 flag 값을 설정합니다.
     * @param itemId 갱신할 아이템 id
     * @param flag 새로운 flag 값
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    fun setFlag(itemId: Int, flag: Boolean) {
        if (itemId <= 0) return

        viewModelScope.launch {
            repository.setFlag(id = itemId, flag = flag)
        }
    }
}

