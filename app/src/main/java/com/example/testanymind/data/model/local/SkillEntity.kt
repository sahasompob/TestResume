package com.example.testanymind.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "skillTable")
data class SkillEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @NotNull
    @ColumnInfo(name = "skillName")
    val skillName: String,
    @NotNull
    @ColumnInfo(name = "resumeId")
    val resumeId: Int
)
