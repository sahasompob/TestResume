package com.example.testanymind.core

import android.app.Application
import com.example.testanymind.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(localModule, viewModelModule, domainModule, repositoryModule, mapperModule)
        }
    }
}