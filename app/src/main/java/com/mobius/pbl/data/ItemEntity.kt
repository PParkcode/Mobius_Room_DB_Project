package com.mobius.pbl.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @file ItemEntity.kt
 * @fn ItemEntity
 * @brief Room에서 사용할 아이템 엔티티입니다.
 */
@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val flag: Boolean,
)

