package com.mobdeve.mp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var data: ArrayList<PostModel>

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the data, recyclerView and adapter
        this.data = DataHelper.initializeData()
        this.recyclerView = findViewById(R.id.horizontalRv)
        this.myAdapter = MyAdapter(this.data)

        // Set the layout manager according to the default view

        val sharedPreferences = getSharedPreferences("com.mobdeve.yourname.exercise3lifecyclesp", MODE_PRIVATE)


        // Initialize the view type and hide like button settings



        // Sets the adapter of the recycler view
        this.recyclerView.adapter = this.myAdapter




    }
}