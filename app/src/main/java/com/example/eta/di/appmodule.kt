package com.example.eta.di

import com.example.eta.model.TextRepository
import com.example.eta.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { TextRepository(androidContext()) }
    viewModel { MainViewModel(get()) }
}