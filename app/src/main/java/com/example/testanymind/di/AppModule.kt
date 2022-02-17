package com.example.testanymind.di

import com.example.testanymind.data.local.database.AppDatabase
import com.example.testanymind.data.model.mapper.ResumeListMapper
import com.example.testanymind.data.model.mapper.ResumeMapper
import com.example.testanymind.repository.ResumeRepository
import com.example.testanymind.repository.ResumeRepositoryImpl
import com.example.testanymind.ui.resume.edit.ResumeEditViewModel
import com.example.testanymind.ui.resume.input.ResumeInputViewModel
import com.example.testanymind.ui.resume.list.ResumeListViewModel
import com.example.testanymind.usecase.GetAllResumeUseCase
import com.example.testanymind.usecase.GetResumeByIdUseCase
import com.example.testanymind.usecase.SaveResumeUseCase
import com.example.testanymind.usecase.UpdateResumeUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val localModule = module {
    single { AppDatabase.getInstance(androidContext()) }
    single { get<AppDatabase>().resumeDao() }
}

val domainModule = module {
    single { SaveResumeUseCase(get()) }
    single { GetAllResumeUseCase(get()) }
    single { GetResumeByIdUseCase(get()) }
    single { UpdateResumeUseCase(get()) }
}

val viewModelModule = module {
    viewModel { ResumeInputViewModel(get()) }
    viewModel { ResumeListViewModel(get()) }
    viewModel { ResumeEditViewModel(get(), get()) }
}

val repositoryModule = module {
    single<ResumeRepository> {
        ResumeRepositoryImpl(get(), get(), get())
    }
}

val mapperModule = module {
    single { ResumeListMapper() }
    single { ResumeMapper() }
}
