package com.mobdeve.mp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView


class CompanyAdapter(private val data: ArrayList<CompanyPostModel>, private val context: Context, private val name: String) : RecyclerView.Adapter<CompanyViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {

        val infalter = LayoutInflater.from(parent.context)
        val newview = infalter.inflate(R.layout.refactor_layout, parent, false)
        val holder = CompanyViewHolder(newview)

        return holder
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        // Please note that bindData is a function we created to adhere to encapsulation. There are
        // many ways to implement the binding of data.
        holder.bindData(data.get(position))

        holder.delete.setOnClickListener {
            val dbHelper = MyDatabaseHelper(context)
            dbHelper.deleteJob(holder.reqs.text.toString(), name)
            ActivityCompat.recreate(context as Activity)
        }
        holder.edit.setOnClickListener {
            val intent = Intent(context, CompanyJobEdit::class.java)
            intent.putExtra("Og_Name", holder.reqs.text.toString())
            intent.putExtra("Company_Name", name)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        // This needs to be modified, so don't forget to add this in.
        return data.size
    }




}