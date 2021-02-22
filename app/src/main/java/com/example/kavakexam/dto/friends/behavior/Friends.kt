package com.example.kavakexam.dto.friends.behavior

import com.example.kavakexam.dto.friends.pojo.FriendsItem

interface Friends {
    interface View{
        fun setFriends(list : List<FriendsItem>)
        fun showOrHideLoader(visible : Boolean)
        fun showError(visible : Boolean)
    }

    interface Presenter{
        fun setView(view: View)
        fun getFriends()
        fun setFriends(list : List<FriendsItem>?)
    }

    interface Model{
        fun setPresenter(presenter: Presenter)
        fun getFriends()
    }

    interface Repository{
        fun getFriends(callback: CallBackServices)
        fun availableNetwork() : Boolean
    }

    interface CallBackServices{
        fun <T> onCompletedCall(response : T)
    }
}