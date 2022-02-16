package com.example.testanymind.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.testanymind.data.model.local.*

@Dao
interface ResumeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addResume(
        resumeEntity: ResumeEntity,
        educationDetailEntity: List<EducationDetailEntity>,
        projectDetailEntity: List<ProjectDetailEntity>,
        skillEntity: List<SkillEntity>,
        workSummaryEntity: List<WorkSummaryEntity>
    )
}
