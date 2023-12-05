package com.mobdeve.mp

import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


/*
var name = name
    private set
var specie = specie
    private set
var location = location
    private set
var desc = desc
    private set
var imageId = imageId
    private set
    */

class StudentViewHolder(itemView: View): ViewHolder(itemView) {

    val reqs: TextView = itemView.findViewById(R.id.jobs)
    val phonenumber: TextView = itemView.findViewById(R.id.phone_number)
    val email: TextView = itemView.findViewById(R.id.email)
    val companyname: TextView = itemView.findViewById(R.id.company_name)
    val booked: Switch = itemView.findViewById(R.id.switchB)

    //    private val task: TextView = itemView.findViewById(R.id.taskView)
    //    private val status:TextView = itemView.findViewById(R.id.Status)
    //    private val status: Boolean = (R.id.button)

    fun bindData(post: StudentPostModel){
        reqs.text = post.requirements
        phonenumber.text = post.phonenumber
        email.text = post.email
        companyname.text = post.companyname

    }
}