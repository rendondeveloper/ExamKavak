package com.example.kavakexam.dagger

import android.app.Application
import com.example.kavakexam.dagger.module.ApiModule
import com.example.kavakexam.dagger.module.FriendsModule

class App : Application() {
    lateinit var applicationModules : ApplicationModules

    override fun onCreate() {
        super.onCreate()

        applicationModules = DaggerApplicationModules
            .builder()
            .applicationApp(ApplicationApp(this))
            .friendsModule(FriendsModule(this))
            .apiModule(ApiModule())
            .build()
    }
}