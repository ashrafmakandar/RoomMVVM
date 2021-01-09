package com.kalyani.kotlinroom.maze.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Data(
    @SerializedName("avatar")
    @ColumnInfo(name = "avatar")
    var avatar: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("id")
    @PrimaryKey
    var id: Int,
    @SerializedName("last_name")
    var lastName: String
)