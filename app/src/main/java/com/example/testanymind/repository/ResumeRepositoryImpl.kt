package com.example.testanymind.repository

import com.example.testanymind.data.local.database.ResumeDao
import com.example.testanymind.data.model.resume.SaveResume
import com.example.testanymind.data.model.mapper.ResumeListMapper
import com.example.testanymind.data.model.mapper.ResumeMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResumeRepositoryImpl(
    private val resumeDao: ResumeDao,
    private val resumeListMapper: ResumeListMapper,
    private val resumeMapper: ResumeMapper
) : ResumeRepository {

    override suspend fun saveResume(saveResume: SaveResume) {
        withContext(Dispatchers.IO) {
            resumeDao.addResume(resumeEntity = saveResume.toResumeEntity())
        }
    }

    override suspend fun updateResume(resume: SaveResume) {
        withContext(Dispatchers.IO) {
            resumeDao.updateResume(resumeEntity = resume.toResumeEntity())
        }
    }

    override suspend fun getAllResume(): List<SaveResume> {
        return withContext(Dispatchers.IO) {
            resumeListMapper.map(resumeDao.getAllResume())
        }
    }

    override suspend fun getResumeById(resumeId: String): SaveResume {
        return withContext(Dispatchers.IO) {
            resumeMapper.map(resumeDao.getResumeById(resumeId))
        }
    }
}