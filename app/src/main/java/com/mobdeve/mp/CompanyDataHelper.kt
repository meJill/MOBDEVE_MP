package com.mobdeve.mp

class CompanyDataHelper {
    companion object{
        fun initializeData(): ArrayList<CompanyPostModel> {
            val company_name = arrayOf("P&G", "JJ", "Uniliver", "Canon")
            val userImages = intArrayOf(
                R.drawable.pg,
                R.drawable.person2,
                R.drawable.person3,
                R.drawable.person4
            )
            val data = ArrayList<CompanyPostModel>()
            data.add(
                CompanyPostModel(
                    "Graphics Designer, IT Manager",

                )
            )
            data.add(
                CompanyPostModel(
                    "Teacher, IT Manager",

                )
            )
            data.shuffle()
            return data
        }
    }

}
