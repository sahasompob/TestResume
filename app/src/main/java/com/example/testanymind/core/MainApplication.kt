package com.example.testanymind.core

import android.app.Application
import com.example.testanymind.di.domainModule
import com.example.testanymind.di.localModule
import com.example.testanymind.di.repositoryModule
import com.example.testanymind.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(localModule, viewModelModule, domainModule, repositoryModule)
        }
    }
}