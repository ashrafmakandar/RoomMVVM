package com.kalyani.kotlinroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.kalyani.kotlinroom.db.Appdb
import com.kalyani.kotlinroom.adapter.adapt
import com.kalyani.kotlinroom.databinding.ActivityMainBinding
import com.kalyani.kotlinroom.viewmodel.postvmodel


class MainActivity : AppCompatActivity() {
    val postss: postvmodel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.pgr.visibility= View.VISIBLE
        postss.getnew()
        val db = Room.databaseBuilder(
            applicationContext,
            Appdb::class.java, "Appdb"
        ).allowMainThreadQueries().build()
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        postss.getall().observe(this, Observer {


            db.postdao().insertAll(it)
            binding.pgr.visibility= View.VISIBLE


        })
       // Toast.makeText(applicationContext,""+db.postdao().getAll(),Toast.LENGTH_SHORT).show()
        binding.recylerviewone.layoutManager = LinearLayoutManager(applicationContext)
        binding.recylerviewone.setHasFixedSize(true)
        var ada = adapt(applicationContext, db.postdao().getAll())

        binding.recylerviewone.adapter = ada
        binding.pgr.visibility= View.INVISIBLE
    }
}