package com.kalyani.kotlinroom.maze.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kalyani.kotlinroom.maze.model.Data
import com.kalyani.kotlinroom.maze.model.Shows
import com.kalyani.kotlinroom.maze.repo.mazerepo

class mazevmodel : ViewModel() {
    var repo = mazerepo()
    var data = MutableLiveData<List<Data>>()


    fun getdata() {
        repo.getmazes()
        data = repo.getnewshows()
    }

    fun getall(): MutableLiveData<List<Data>> {
        return data
    }
}