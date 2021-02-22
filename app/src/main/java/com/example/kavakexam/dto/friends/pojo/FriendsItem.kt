package com.example.kavakexam.dto.friends.pojo

import com.google.gson.annotations.Expose

class FriendsItem (
    @Expose
    val id: Long,
    @Expose
    val name: String,
    @Expose
    val thumbnail: String,
    @Expose
    val age: Long,
    @Expose
    val weight: Double,
    @Expose
    val height: Double,
    @Expose()
    val hair_color: String,
    @Expose
    val professions: List<String>,
    @Expose
    val friends: List<String>
)