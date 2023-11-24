package com.mobdeve.mp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class CompanyAdapter(private val data: ArrayList<CompanyPostModel>/*, private val dbHelper: MyDatabaseHelper*/) : RecyclerView.Adapter<CompanyViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {

        val infalter = LayoutInflater.from(parent.context)
        val newview = infalter.inflate(R.layout.horizontal_layout, parent, false)

        return CompanyViewHolder(newview)
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        // Please note that bindData is a function we created to adhere to encapsulation. There are
        // many ways to implement the binding of data.
        holder.bindData(data.get(position))
//        holder.delete.setOnClickListener {
//            dbHelper.deleteJobByName(holder.reqs.toString())
//        }
    }

    override fun getItemCount(): Int {
        // This needs to be modified, so don't forget to add this in.
        return data.size
    }
}