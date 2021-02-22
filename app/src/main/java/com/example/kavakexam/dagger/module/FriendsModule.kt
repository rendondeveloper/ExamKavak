package com.example.kavakexam.dagger.module
import android.app.Application
import android.content.Context
import com.example.kavakexam.dto.friends.behavior.Friends
import com.example.kavakexam.dto.friends.behavior.FriendsServices
import com.example.kavakexam.view.friends.model.FriendsModel
import com.example.kavakexam.view.friends.presenter.FriendsPresenter
import com.example.kavakexam.view.friends.repository.FriendsRepository
import dagger.Module
import dagger.Provides

@Module
class FriendsModule(private val application: Application) {

    @Provides
    fun providerPresenter( model : Friends.Model) : Friends.Presenter{
        return FriendsPresenter(model);
    }

    @Provides
    fun providerModel(repository: Friends.Repository) : Friends.Model {
        return FriendsModel(repository);
    }

    @Provides
    fun providerRepository(friendsServices: FriendsServices) : Friends.Repository {
        return FriendsRepository(friendsServices, application)
    }
}