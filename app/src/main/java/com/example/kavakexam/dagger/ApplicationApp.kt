package com.example.kavakexam.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationApp
    constructor(private val application: Application){

    @Provides
    @Singleton
    fun providerContext() : Context {
        return  application;
    }
}