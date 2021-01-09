package com.kalyani.kotlinroom.repo

import androidx.lifecycle.MutableLiveData
import com.kalyani.kotlinroom.model.PostsItem
import com.kalyani.kotlinroom.service.postapi
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class postrepos {
    var datalist = MutableLiveData<List<PostsItem>>()

    fun getdata() {
var r = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()
var rr= r.create(postapi::class.java)
      rr.getall().enqueue(object : Callback<List<PostsItem>> {
            override fun onResponse(
                call: Call<List<PostsItem>>,
                response: Response<List<PostsItem>>
            ) {
                datalist.value = response.body()

            }

            override fun onFailure(call: Call<List<PostsItem>>, t: Throwable) {

            }

        });

    }


    fun getmutdata(): MutableLiveData<List<PostsItem>> {
        return datalist
    }
}