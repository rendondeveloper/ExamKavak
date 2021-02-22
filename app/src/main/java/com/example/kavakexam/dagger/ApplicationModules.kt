package com.example.kavakexam.dagger

import com.example.kavakexam.dagger.module.ApiModule
import com.example.kavakexam.dagger.module.FriendsModule
import com.example.kavakexam.view.friends.view.FriendsView
import dagger.Component

@Component(modules = [ ApplicationApp::class, FriendsModule::class, ApiModule::class])
interface ApplicationModules{
    fun inject(view : FriendsView)
}