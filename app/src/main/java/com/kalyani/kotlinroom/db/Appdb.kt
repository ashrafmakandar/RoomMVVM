package com.kalyani.kotlinroom.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kalyani.kotlinroom.model.PostsItem

@Database(entities = arrayOf(PostsItem::class),version = 1)
abstract  class Appdb : RoomDatabase() {
    abstract  fun postdao(): postdao
}