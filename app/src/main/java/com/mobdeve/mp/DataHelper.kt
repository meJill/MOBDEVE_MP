package com.mobdeve.mp

import com.mobdeve.mp.Models.Company

class DataHelper {
    companion object{
        fun initializeData(): ArrayList<PostModel> {
            val company_name = arrayOf("P&G", "JJ", "Uniliver", "Canon")
            val userImages = intArrayOf(
                R.drawable.pg,
                R.drawable.person2,
                R.drawable.person3,
                R.drawable.person4
            )
            val data = ArrayList<PostModel>()
            data.add(
                PostModel(
                    "Graphics Designer, IT Manager",
                    "9183745",
                    "testemail@gmail.com",
                    company_name[0],
                    userImages[0]
                )
            )
            data.add(
                PostModel(
                    "Teacher, IT Manager",
                    "9183745",
                    "testemail@gmail.com",
                    company_name[1],
                    userImages[1]
                )
            )
            data.shuffle()
            return data
        }
    }

}
