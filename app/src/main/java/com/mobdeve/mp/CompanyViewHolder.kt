package com.mobdeve.mp

import android.view.View
import android.widget.ImageButton
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

class CompanyViewHolder(itemView: View): ViewHolder(itemView) {

    val reqs: TextView = itemView.findViewById(R.id.jobs2)
    val delete: ImageButton = itemView.findViewById(R.id.jobD)
    val edit: ImageButton = itemView.findViewById(R.id.jobE)

    fun bindData(post: CompanyPostModel){
        reqs.text = post.requirements
    }




}