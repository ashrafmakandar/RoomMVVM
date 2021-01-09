package com.kalyani.kotlinroom.maze.repo

import androidx.lifecycle.MutableLiveData
import com.kalyani.kotlinroom.maze.model.Data
import com.kalyani.kotlinroom.maze.model.Shows
import com.kalyani.kotlinroom.maze.service.mazeapi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class mazerepo {

    var data = MutableLiveData<List<Data>>()

    fun getmazes() {

        var r = Retrofit.Builder().baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        var api = r.create(mazeapi::class.java)
        api.getmazes().enqueue(object : Callback<Shows> {
            override fun onResponse(call: Call<Shows>, response: Response<Shows>) {
               data.value= response.body()?.data
            }

            override fun onFailure(call: Call<Shows>, t: Throwable) {

            }


        })


    }


    fun getnewshows(): MutableLiveData<List<Data>> {
        return data
    }
}