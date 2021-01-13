package com.kalyani.kotlinroom.maze.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kalyani.kotlinroom.maze.model.Data
import com.kalyani.kotlinroom.maze.model.Shows
import com.kalyani.kotlinroom.todo.db.postdao

@Database(entities = arrayOf(Data::class),version = 1 ,exportSchema = false)
abstract class mazedb: RoomDatabase() {
    abstract  fun mazedao(): mazedao

}