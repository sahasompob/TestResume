package com.example.testanymind.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "workSummaryTable")
data class WorkSummaryEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @NotNull
    @ColumnInfo(name = "companyName")
    val companyName: String,
    @NotNull
    @ColumnInfo(name = "duration")
    val duration: String,
    @NotNull
    @ColumnInfo(name = "resumeId")
    val resumeId: Int
)
