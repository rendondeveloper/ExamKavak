package com.example.kavakexam.view.friends.view

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kavakexam.R
import com.example.kavakexam.dagger.App
import com.example.kavakexam.dto.friends.adapter.AdapterFriends
import com.example.kavakexam.dto.friends.behavior.Friends
import com.example.kavakexam.dto.friends.pojo.FriendsItem
import kotlinx.android.synthetic.main.activity_friends.*
import javax.inject.Inject

class FriendsView : Friends.View, AppCompatActivity() {

    @Inject
    lateinit var presenter :  Friends.Presenter

    lateinit var friendsAdapter : AdapterFriends

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends);
        loadView();
    }

    private fun loadView(){
        (this.application as App).applicationModules.inject(this)
        this.presenter.setView(this);
        btnReload.setOnClickListener { this.presenter.getFriends()}
    }

    override fun onResume() {
        super.onResume()
        this.presenter.getFriends()
    }

    override fun setFriends(list: List<FriendsItem>) {
        friendsAdapter = AdapterFriends(list = list)
        rvData.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvData.adapter = friendsAdapter
        runAnimation();
    }

    override fun showOrHideLoader(visible: Boolean) {
        rlProgress.visibility = if(visible) View.VISIBLE else View.GONE
    }

    override fun showError(visible: Boolean) {
        llError.visibility = if(visible) View.VISIBLE else View.GONE
    }

    private fun runAnimation() {
        val controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_left_to_right);
        rvData.layoutAnimation = controller
        friendsAdapter.notifyDataSetChanged();
        rvData.scheduleLayoutAnimation();
    }

}