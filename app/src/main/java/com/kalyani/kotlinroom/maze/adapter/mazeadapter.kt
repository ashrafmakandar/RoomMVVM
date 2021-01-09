package com.kalyani.kotlinroom.maze.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kalyani.kotlinroom.R
import com.kalyani.kotlinroom.maze.model.Data

class mazeadapter(var context: Context, var list: List<Data>) :
    RecyclerView.Adapter<mazeadapter.mazeholder>() {


    class mazeholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      var imageview = itemView.findViewById<ImageView>(R.id.images)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mazeholder {
        var view = LayoutInflater.from(context).inflate(R.layout.image_card, parent, false)
        return mazeholder(view)
    }

    override fun onBindViewHolder(holder: mazeholder, position: Int) {
        Glide.with(context).load(list[position].avatar).into(holder.imageview);
    }

    override fun getItemCount(): Int {
        return list.size
    }
}