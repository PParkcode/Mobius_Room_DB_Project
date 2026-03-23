package com.mobius.pbl.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * @file ItemDao.kt
 * @fn ItemDao
 * @brief Room DB에 대한 CRUD 연산을 제공합니다.
 */
@Dao
interface ItemDao {
    /**
     * @brief 생성 순서(= `id` 오름차순) 기준으로 모든 아이템을 관찰합니다.
     * @return 아이템 리스트 스트림
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    @Query("SELECT id, title, flag FROM items ORDER BY id ASC")
    fun observeAll(): Flow<List<ItemEntity>>

    /**
     * @brief 새로운 아이템을 삽입합니다. (flag는 별도 요구사항에 따라 기본값을 사용하는 쪽에서 설정)
     * @param item 삽입할 아이템
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    @Insert
    suspend fun insert(item: ItemEntity)

    /**
     * @brief 특정 아이템을 삭제합니다.
     * @param id 삭제할 아이템 id
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    @Query("DELETE FROM items WHERE id = :id")
    suspend fun deleteById(id: Int)

    /**
     * @brief 특정 아이템의 flag 값을 갱신합니다.
     * @param id 갱신할 아이템 id
     * @param flag 새로운 flag 값
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    @Query("UPDATE items SET flag = :flag WHERE id = :id")
    suspend fun setFlag(id: Int, flag: Boolean)
}

