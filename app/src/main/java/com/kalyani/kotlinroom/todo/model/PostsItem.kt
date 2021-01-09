package com.kalyani.kotlinroom.todo.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class PostsItem(
    @SerializedName("body")
    var body: String,
    @PrimaryKey
    @SerializedName("id")
    var id: Int,
    @ColumnInfo(name = "first_name")
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: Int
)