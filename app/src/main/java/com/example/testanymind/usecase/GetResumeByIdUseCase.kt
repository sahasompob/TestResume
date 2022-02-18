package com.example.testanymind.usecase

import com.example.testanymind.base.BaseSuspendUseCase
import com.example.testanymind.data.model.resume.SaveResume
import com.example.testanymind.repository.ResumeRepository

class GetResumeByIdUseCase(
    private val resumeRepository: ResumeRepository
) : BaseSuspendUseCase<GetResumeByIdUseCase.Input, SaveResume>() {

    override suspend fun create(input: Input): SaveResume {
        return resumeRepository.getResumeById(input.resumeId)
    }

    data class Input(
        val resumeId: String
    )

}