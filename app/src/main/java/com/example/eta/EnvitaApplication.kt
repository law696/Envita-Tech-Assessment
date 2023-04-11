package com.example.eta

import android.app.Application
import com.example.eta.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class EnvitaApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EnvitaApplication)
            modules(appModule)
        }
    }
}