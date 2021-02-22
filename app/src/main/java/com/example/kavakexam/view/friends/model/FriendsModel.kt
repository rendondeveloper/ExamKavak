package com.example.kavakexam.view.friends.model

import com.example.kavakexam.dto.friends.behavior.Friends
import com.example.kavakexam.dto.friends.pojo.FriendsResponse

class FriendsModel(val repository: Friends.Repository) : Friends.Model {

    private lateinit var presenter: Friends.Presenter

    override fun setPresenter(presenter: Friends.Presenter) {
        this.presenter = presenter
    }

    override fun getFriends() {

        if(!repository.availableNetwork()){
            this.presenter.setFriends(null);
            return
        }

        this.repository.getFriends( object : Friends.CallBackServices {
            override fun <T> onCompletedCall(response: T) {
                if (response is FriendsResponse) {
                    presenter.setFriends(response.Brastlewark);
                } else if (response is Throwable) {
                    presenter.setFriends(null);
                }
            }
        }
        );
    }



}