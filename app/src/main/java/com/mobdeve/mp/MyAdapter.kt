package com.mobdeve.mp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.act1.ferrer.fakeadex.PostViewHolder

class MyAdapter(private val data: ArrayList<PostModel>) : RecyclerView.Adapter<PostViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val infalter = LayoutInflater.from(parent.context)

        val view = infalter.inflate(R.layout.horizontal_layout, parent, false)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        // Please note that bindData is a function we created to adhere to encapsulation. There are
        // many ways to implement the binding of data.
        holder.bindData(data.get(position))
    }

    override fun getItemCount(): Int {
        // This needs to be modified, so don't forget to add this in.
        return data.size
    }
}