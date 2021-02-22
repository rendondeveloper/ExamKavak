package com.example.kavakexam.dto.friends.behavior
import com.example.kavakexam.dto.friends.pojo.FriendsResponse
import retrofit2.Call
import retrofit2.http.GET

interface FriendsServices{
    @GET("rrafols/mobile_test/master/data.json")
    fun getAllTypeCoin() : Call<FriendsResponse>
}