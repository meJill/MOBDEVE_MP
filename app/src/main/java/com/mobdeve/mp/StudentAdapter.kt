package com.mobdeve.mp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val data: ArrayList<StudentPostModel>) : RecyclerView.Adapter<StudentViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {

        val infalter = LayoutInflater.from(parent.context)

        val view = infalter.inflate(R.layout.vertical_layout, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        // Please note that bindData is a function we created to adhere to encapsulation. There are
        // many ways to implement the binding of data.
        holder.bindData(data.get(position))
        holder.booked.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }

    override fun getItemCount(): Int {
        // This needs to be modified, so don't forget to add this in.
        return data.size
    }
}