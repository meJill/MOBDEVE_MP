package com.mobdeve.mp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var data: ArrayList<PostModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the data, recyclerView, and adapter
        this.data = DataHelper.initializeData()
        this.recyclerView = findViewById(R.id.horizontalRv)
        this.myAdapter = MyAdapter(this.data)

        // Set the layout manager according to the default view

        val sharedPreferences = getSharedPreferences("com.mobdeve.yourname.exercise3lifecyclesp", MODE_PRIVATE)

        // Initialize the view type and hide like button settings
        // Add your code for initializing view type and hiding like button

        // Sets the adapter of the recycler view
        this.recyclerView.adapter = this.myAdapter

        val buttonClick = findViewById<Button>(R.id.add_button)
        buttonClick?.setOnClickListener {
            val intent = Intent(this, AddReq::class.java)
            startActivity(intent)
        }
    }
}
