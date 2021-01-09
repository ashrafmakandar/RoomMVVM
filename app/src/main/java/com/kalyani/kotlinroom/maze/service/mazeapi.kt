package com.kalyani.kotlinroom.maze.service

import com.kalyani.kotlinroom.maze.model.Shows
import retrofit2.Call
import retrofit2.http.GET

interface mazeapi {

    @GET("users?page=2")
    fun getmazes(): Call<Shows>
}