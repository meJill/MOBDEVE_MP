package com.mobdeve.mp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val data: ArrayList<StudentPostModel>, private val context: Context, private val name: String) : RecyclerView.Adapter<StudentViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {

        val infalter = LayoutInflater.from(parent.context)

        val view = infalter.inflate(R.layout.bookmark_layout, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindData(data.get(position))
        val dbHelper = MyDatabaseHelper(context)
        dbHelper.getBookedCompanies(name).forEach { i ->
            if (i.companyname == holder.companyname.text) {
                holder.booked.isChecked = true
            }
        }
        holder.booked.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                println("YES")
                dbHelper.addBookmark(name, holder.companyname.text.toString())
            } else {
                println("NO")
                dbHelper.deleteBookmark(name, holder.companyname.text.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}