package com.example.testanymind.usecase

import com.example.testanymind.base.BaseSuspendUseCase
import com.example.testanymind.data.model.resume.SaveResume
import com.example.testanymind.repository.ResumeRepository

class UpdateResumeUseCase(
    private val resumeRepository: ResumeRepository
) : BaseSuspendUseCase<UpdateResumeUseCase.Input, Unit>() {

    override suspend fun create(input: Input) {
        resumeRepository.updateResume(input.resume)
    }

    data class Input(
        val resume: SaveResume
    )

}