package com.mobdeve.mp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mobdeve.mp.PostModel
import com.mobdeve.mp.R


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
    var delete: Button = itemView.findViewById(R.id.jobD)

    fun bindData(post: CompanyPostModel){
        reqs.text = post.requirements
    }




}