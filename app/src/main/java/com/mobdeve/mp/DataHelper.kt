package com.mobdeve.mp

import com.mobdeve.mp.Models.Company

class DataHelper {
    companion object{
        fun studentData(companyNames: List<PostModel>): ArrayList<PostModel> {
            val data = ArrayList<PostModel>()
            companyNames.forEach { i ->
                data.add(
                    PostModel(
                        i.requirements.toString(),
                        i.phonenumber.toString(),
                        i.email.toString(),
                        i.companyname.toString()
                    )
                )
            }

            return data
        }
    }

}
