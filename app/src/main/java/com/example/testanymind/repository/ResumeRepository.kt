package com.example.testanymind.repository

import com.example.testanymind.data.model.SaveResume

interface ResumeRepository {
    suspend fun saveResume(saveResume: SaveResume)
    suspend fun updateResume(resume: SaveResume)
    suspend fun getAllResume(): List<SaveResume>
    suspend fun getResumeById(resumeId:String): SaveResume
}