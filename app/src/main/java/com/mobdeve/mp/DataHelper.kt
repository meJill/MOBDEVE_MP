package com.mobdeve.mp

class DataHelper {
    companion object{
    fun initializeData(): ArrayList<PostModel> {
        val usernames = arrayOf("Wonderer", "JustMe", "TravelingNomad", "WelcomeToMyLife")
        val userImages = intArrayOf(
            R.drawable.person1,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4
        )
        val data = ArrayList<PostModel>()
        data.add(
            PostModel(
                "Graphics Designer, IT Manager",
                "that's a tall boi",
                "New York, NY, USA",
                "P&G",
                "Done",
                userImages[0]
            )
        )
        return data
        }
    }
}