package com.mobius.pbl.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @file AppDatabase.kt
 * @fn AppDatabase
 * @brief Room 데이터베이스 스키마를 정의합니다.
 */
@Database(
    entities = [ItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    /**
     * @brief ItemDao를 제공합니다.
     * @return ItemDao
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    abstract fun itemDao(): ItemDao
}

