package com.example.testanymind.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "resumeTable")
data class ResumeEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @NotNull
    @ColumnInfo(name = "picture")
    val picture: String,
    @NotNull
    @ColumnInfo(name = "mobile")
    val mobile: String,
    @NotNull
    @ColumnInfo(name = "email")
    val email: String,
    @NotNull
    @ColumnInfo(name = "residence")
    val residence: String,
    @NotNull
    @ColumnInfo(name = "career")
    val career: String,
    @NotNull
    @ColumnInfo(name = "totalYear")
    val totalYear: String,
    @NotNull
    @ColumnInfo(name = "skill")
    val skill: String,
    @NotNull
    @ColumnInfo(name = "workSummary")
    val workSummary: String,
    @NotNull
    @ColumnInfo(name = "educationDetail")
    val educationDetail: String,
    @NotNull
    @ColumnInfo(name = "projectDetail")
    val projectDetail: String
)
