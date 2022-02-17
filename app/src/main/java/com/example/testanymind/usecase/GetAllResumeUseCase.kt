package com.example.testanymind.usecase

import com.example.testanymind.base.BaseSuspendUseCase
import com.example.testanymind.data.model.SaveResume
import com.example.testanymind.repository.ResumeRepository

class GetAllResumeUseCase(
    private val resumeRepository: ResumeRepository
) : BaseSuspendUseCase<Unit, List<SaveResume>>() {

    override suspend fun create(input: Unit): List<SaveResume> {
        return resumeRepository.getAllResume()
    }

}