package com.kalyani.kotlinroom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kalyani.kotlinroom.R
import com.kalyani.kotlinroom.model.PostsItem

class adapt(var context: Context, var list: List<PostsItem>) :
    RecyclerView.Adapter<adapt.holder>() {


    class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textone = itemView.findViewById<TextView>(R.id.texts)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        var v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false)
        return holder(v)
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.textone.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }
}