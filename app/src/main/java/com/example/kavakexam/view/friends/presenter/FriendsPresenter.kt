package com.example.kavakexam.view.friends.presenter

import com.example.kavakexam.dto.friends.behavior.Friends
import com.example.kavakexam.dto.friends.pojo.FriendsItem

class FriendsPresenter constructor(
    private val model : Friends.Model) : Friends.Presenter {

    private lateinit var view : Friends.View

    override fun setView(view: Friends.View) {
        this.view = view
    }

    override fun getFriends() {
        this.view.showOrHideLoader(true)
        this.model.setPresenter(this)
        this.model.getFriends();
    }

    override fun setFriends(list: List<FriendsItem>?) {
        view.showOrHideLoader(false)
        if(list == null){
            view.showError(true);
        }else{
            view.setFriends(list);
        }
    }
}