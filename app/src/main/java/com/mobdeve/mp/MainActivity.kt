package com.mobdeve.mp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.fragments.bookFragment
import com.mobdeve.mp.ui.login.loginFragment
import com.mobdeve.mp.fragments.FullscreenFragment
import com.mobdeve.mp.fragments.ScrollingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var data: ArrayList<PostModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private lateinit var navigationView: BottomNavigationView

    private val todoFragment = ScrollingFragment() // Replace with your actual fragment class
    private val homeFragment = FullscreenFragment()
    private val bookFragment = bookFragment()// Replace with your actual fragment class
    private val loginFragment = loginFragment()// Replace with your actual fragment class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the data, recyclerView, and adapter
        this.data = DataHelper.initializeData()

        this.myAdapter = MyAdapter(this.data)


        val sharedPreferences = getSharedPreferences("com.mobdeve.yourname.exercise3lifecyclesp", MODE_PRIVATE)

        // Initialize the view type and hide like button settings
        // Add your code for initializing view type and hiding like button

        // Sets the adapter of the recycler view


        val buttonClick = findViewById<FloatingActionButton>(R.id.add_button)
        buttonClick?.setOnClickListener {
            val intent = Intent(this, AddReq::class.java)
            startActivity(intent)

        }

        navigationView = findViewById(R.id.nav_view)
        navigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(homeFragment)
                    true
                }
                R.id.todo -> {
                    replaceFragment(todoFragment)
                    true
                }
                R.id.bookmark -> {
                    replaceFragment(bookFragment)
                    true
                }
                R.id.login -> {
                    replaceFragment(loginFragment)
                    true
                }

                else -> false
            }
        }
        replaceFragment(homeFragment)
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(null)
            .commit()
    }
}
