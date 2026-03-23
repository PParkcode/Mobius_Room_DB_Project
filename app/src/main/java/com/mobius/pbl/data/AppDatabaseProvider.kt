package com.mobius.pbl.data

import android.content.Context
import androidx.room.Room

/**
 * @file AppDatabaseProvider.kt
 * @fn AppDatabaseProvider
 * @brief Room DB 싱글톤을 제공하는 헬퍼입니다.
 */
object AppDatabaseProvider {
    private const val DB_NAME = "mobius_items.db"

    @Volatile
    private var INSTANCE: AppDatabase? = null

    /**
     * @brief application context 기반으로 Room DB 인스턴스를 반환합니다.
     * @param context application context
     * @return AppDatabase 인스턴스
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    fun get(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).build().also { INSTANCE = it }
        }
    }
}

