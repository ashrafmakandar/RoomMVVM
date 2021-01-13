package com.kalyani.kotlinroom.todo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kalyani.kotlinroom.todo.model.PostsItem

@Database(entities = arrayOf(PostsItem::class),version = 1,exportSchema = false)
abstract  class Appdb : RoomDatabase() {
    abstract  fun postdao(): postdao
}