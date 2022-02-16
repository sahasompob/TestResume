package com.example.testanymind.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "educationDetailTable")
data class EducationDetailEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @NotNull
    @ColumnInfo(name = "className")
    val className: String,
    @NotNull
    @ColumnInfo(name = "passingYear")
    val passingYear: String,
    @NotNull
    @ColumnInfo(name = "percentGPA")
    val percentGPA: String,
    @NotNull
    @ColumnInfo(name = "resumeId")
    val resumeId: Int
)
