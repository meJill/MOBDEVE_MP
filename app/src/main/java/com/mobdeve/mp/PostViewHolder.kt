package com.mobdeve.act1.ferrer.fakeadex

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

class PostViewHolder(itemView: View): ViewHolder(itemView) {

    private val reqs: TextView = itemView.findViewById(R.id.jobs)
    private val phonenumber: TextView = itemView.findViewById(R.id.phone_number)
    private val email: TextView = itemView.findViewById(R.id.email)
    private val companyname: TextView = itemView.findViewById(R.id.company_name)
//    private val status: Boolean = (R.id.button)
    private val userimage: ImageView = itemView.findViewById(R.id.accountImageIv)
    private val task: TextView = itemView.findViewById(R.id.taskView)
    private val status:TextView = itemView.findViewById(R.id.Status)

    fun bindData(post: PostModel){
        reqs.text = post.requirements
        phonenumber.text = post.phonenumber
        email.text = post.email
        companyname.text = post.companyname
        task.text = post.tasks
        status.text = post.status

        if(post.status == "Done"){
//            button.setImageResource(R.drawable.heart_one)
        }
        else{
//            button.setImageResource(R.drawable.heart)
        }

//        val check = post.liked
//
//        button.setOnClickListener{
//            post.liked = !post.liked
//            if (post.liked) {
//                button.setImageResource(R.drawable.heart_one)
//            } else {
//                button.setImageResource(R.drawable.heart)
//            }}

    }


}