package com.kalyani.kotlinroom.service

import com.kalyani.kotlinroom.model.PostsItem
import retrofit2.Call
import retrofit2.http.GET

interface postapi {

    @GET("posts")
    fun getall(): Call<List<PostsItem>>

}