package com.example.testanymind.repository

import com.example.testanymind.data.model.SaveResume

interface ResumeRepository {
    suspend fun saveResume(saveResume: SaveResume)
    suspend fun getAllResume(): SaveResume
}