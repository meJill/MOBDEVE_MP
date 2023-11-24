package com.mobdeve.mp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CompanyAdapter(private val data: ArrayList<CompanyPostModel>, private val context: Context) : RecyclerView.Adapter<CompanyViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {

        val infalter = LayoutInflater.from(parent.context)
        val newview = infalter.inflate(R.layout.horizontal_layout, parent, false)
        val holder = CompanyViewHolder(newview)

        return holder
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        // Please note that bindData is a function we created to adhere to encapsulation. There are
        // many ways to implement the binding of data.
        holder.bindData(data.get(position))

    }

    override fun getItemCount(): Int {
        // This needs to be modified, so don't forget to add this in.
        return data.size
    }



}