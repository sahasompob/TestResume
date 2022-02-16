package com.example.testanymind.repository

import com.example.testanymind.data.local.database.ResumeDao
import com.example.testanymind.data.model.SaveResume
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResumeRepositoryImpl(
    private val resumeDao: ResumeDao
) : ResumeRepository {

    override suspend fun saveResume(saveResume: SaveResume) {
        withContext(Dispatchers.IO) {
            resumeDao.addResume(
                resumeEntity = saveResume.toResumeEntity(),
                educationDetailEntity = saveResume.toEducationDetailEntity(),
                projectDetailEntity = saveResume.toProjectDetailEntity(),
                skillEntity = saveResume.toSkillEntity(),
                workSummaryEntity = saveResume.toWorkSummaryEntity()
            )
        }
    }

    override suspend fun getAllResume(): SaveResume {
        TODO("Not yet implemented")
    }
}