package com.kalyani.kotlinroom.maze.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.kalyani.kotlinroom.databinding.ActivityMazeBinding
import com.kalyani.kotlinroom.maze.adapter.mazeadapter
import com.kalyani.kotlinroom.maze.db.mazedb
import com.kalyani.kotlinroom.maze.viewmodel.mazevmodel

class Maze : AppCompatActivity() {
    val mazevmodel: mazevmodel by viewModels()

    private lateinit var binding: ActivityMazeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMazeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mazevmodel.getdata()
        var db = Room.databaseBuilder(applicationContext, mazedb::class.java, "mazedb")
            .allowMainThreadQueries().build()
        mazevmodel.getall().observe(this, Observer {
           // Toasty.success(applicationContext, "" + it, Toasty.LENGTH_LONG).show()
            db.mazedao().insertAll(it)
            binding.pgrs.visibility= View.VISIBLE
        })

        binding.mazerecview.layoutManager = LinearLayoutManager(applicationContext)
        binding.mazerecview.setHasFixedSize(true)
        var ada = mazeadapter(applicationContext,db.mazedao().getAll())

        binding.mazerecview.adapter = ada
        binding.pgrs.visibility= View.INVISIBLE
    }
}