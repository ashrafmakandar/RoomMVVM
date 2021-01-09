package com.kalyani.kotlinroom.todo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kalyani.kotlinroom.todo.model.PostsItem
@Dao
interface postdao {
    @Query("SELECT * FROM PostsItem")
    fun getAll(): List<PostsItem>




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<PostsItem>)

}