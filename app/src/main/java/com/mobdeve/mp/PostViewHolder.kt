package com.mobdeve.act1.ferrer.fakeadex

import android.view.View
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

    private val reqs: TextView = itemView.findViewById(R.id.textView)
    private val uname: TextView = itemView.findViewById(R.id.username)
    private val loc: TextView = itemView.findViewById(R.id.location)
    private val mainimg: ImageView = itemView.findViewById(R.id.mainpicture)
    private val button: ImageView = itemView.findViewById(R.id.button)
    private val uname2: TextView = itemView.findViewById(R.id.username2)
    private val desc: TextView = itemView.findViewById(R.id.description)
    private val date: TextView = itemView.findViewById(R.id.date)



    fun bindData(post: PostModel){
        dp.setImageResource(post.userImageId)
        uname.text = post.username
        loc.text = post.location
        mainimg.setImageResource(post.imageId)
        uname2.text = post.username
        desc.text = post.caption
        date.text = post.datePosted

        if(post.liked == true){
            button.setImageResource(R.drawable.heart_one)
        }
        else{
            button.setImageResource(R.drawable.heart)
        }

        val check = post.liked

        button.setOnClickListener{
            post.liked = !post.liked
            if (post.liked) {
                button.setImageResource(R.drawable.heart_one)
            } else {
                button.setImageResource(R.drawable.heart)
            }}

    }


}