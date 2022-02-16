package com.example.testanymind.di

import com.example.testanymind.data.local.database.AppDatabase
import com.example.testanymind.repository.ResumeRepository
import com.example.testanymind.repository.ResumeRepositoryImpl
import com.example.testanymind.ui.resume.input.ResumeInputViewModel
import com.example.testanymind.ui.resume.list.ResumeListViewModel
import com.example.testanymind.usecase.SaveResumeUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val localModule = module {
    single { AppDatabase.getInstance(androidContext()) }
    single { get<AppDatabase>().resumeDao() }
}

val domainModule = module {
    single { SaveResumeUseCase(get()) }
}

val viewModelModule = module {
    viewModel { ResumeInputViewModel(get()) }
    viewModel { ResumeListViewModel() }
}

val repositoryModule = module {
    single<ResumeRepository> {
        ResumeRepositoryImpl(get())
    }
}
