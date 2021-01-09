package com.kalyani.kotlinroom.maze.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kalyani.kotlinroom.maze.model.Data
import com.kalyani.kotlinroom.maze.model.Shows

@Dao
interface mazedao {
    @Query("SELECT * FROM Data")
    fun getAll(): List<Data>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<Data>)


}