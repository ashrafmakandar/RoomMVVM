package com.kalyani.kotlinroom.todo.service

import com.kalyani.kotlinroom.todo.model.PostsItem
import retrofit2.Call
import retrofit2.http.GET

interface postapi {

    @GET("posts")
    fun getall(): Call<List<PostsItem>>

}