package com.example.testanymind.usecase

import com.example.testanymind.base.BaseSuspendUseCase
import com.example.testanymind.data.model.SaveResume
import com.example.testanymind.repository.ResumeRepository

class SaveResumeUseCase(
    private val resumeRepository: ResumeRepository
) : BaseSuspendUseCase<SaveResumeUseCase.Input, Unit>() {

    override suspend fun create(input: Input) {
        resumeRepository.saveResume(input.saveResume)
    }

    data class Input(
        val saveResume: SaveResume
    )

}