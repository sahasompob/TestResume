package com.example.testanymind.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "projectDetailTable")
data class ProjectDetailEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @NotNull
    @ColumnInfo(name = "projectName")
    val projectName: String,
    @NotNull
    @ColumnInfo(name = "teamSize")
    val teamSize: String,
    @NotNull
    @ColumnInfo(name = "projectSummary")
    val projectSummary: String,
    @NotNull
    @ColumnInfo(name = "technologyUsed")
    val technologyUsed: String,
    @NotNull
    @ColumnInfo(name = "role")
    val role: String,
    @NotNull
    @ColumnInfo(name = "resumeId")
    val resumeId: Int
)
