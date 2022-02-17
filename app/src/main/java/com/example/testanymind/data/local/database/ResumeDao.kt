package com.example.testanymind.data.local.database

import androidx.room.*
import com.example.testanymind.data.model.local.ResumeEntity

@Dao
interface ResumeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addResume(resumeEntity: ResumeEntity)

    @Update
    fun updateResume(resumeEntity: ResumeEntity)

    @Query("SELECT * FROM resumeTable")
    fun getAllResume(): List<ResumeEntity>

    @Query("SELECT * FROM resumeTable WHERE id LIKE :resumeId")
    fun getResumeById(resumeId: String): ResumeEntity
}
