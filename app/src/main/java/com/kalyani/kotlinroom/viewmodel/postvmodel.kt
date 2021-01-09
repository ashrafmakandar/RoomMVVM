package com.kalyani.kotlinroom.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kalyani.kotlinroom.model.PostsItem
import com.kalyani.kotlinroom.repo.postrepos

class postvmodel : ViewModel() {
var reposs= postrepos();

    var data = MutableLiveData<List<PostsItem>>()


    fun getnew() {
        reposs.getdata()
        data = reposs.getmutdata()
    }


    fun getall(): MutableLiveData<List<PostsItem>> {
        return data
    }
}