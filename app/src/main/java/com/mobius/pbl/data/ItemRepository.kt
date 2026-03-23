package com.mobius.pbl.data

import kotlinx.coroutines.flow.Flow

/**
 * @file ItemRepository.kt
 * @fn ItemRepository
 * @brief Room DAO를 캡슐화해 ViewModel/Receiver에서 사용할 데이터 접근 레이어입니다.
 */
class ItemRepository(
    private val itemDao: ItemDao
) {
    /**
     * @brief 생성 순서(id 오름차순) 기준으로 정렬된 아이템 리스트 스트림입니다.
     * @return 아이템 리스트 Flow
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    val items: Flow<List<ItemEntity>> = itemDao.observeAll()

    /**
     * @brief 새로운 아이템을 생성하여 저장합니다. (flag는 기본 false)
     * @param title 저장할 title
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    suspend fun add(title: String) {
        itemDao.insert(ItemEntity(title = title, flag = false))
    }

    /**
     * @brief 특정 아이템을 삭제합니다.
     * @param id 삭제할 아이템 id
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    suspend fun deleteById(id: Int) {
        itemDao.deleteById(id)
    }

    /**
     * @brief 특정 아이템의 flag 값을 설정합니다.
     * @param id 갱신할 아이템 id
     * @param flag 새 flag 값
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    suspend fun setFlag(id: Int, flag: Boolean) {
        itemDao.setFlag(id = id, flag = flag)
    }
}

