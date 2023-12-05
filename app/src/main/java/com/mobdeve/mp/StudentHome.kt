package com.mobdeve.mp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.fragments.bookFragment // Ensure correct import for your BookFragment
import com.mobdeve.mp.fragments.homeFragment

class StudentHome : AppCompatActivity() {
    private lateinit var bookmarkButton: FloatingActionButton
    private val bookFragment = bookFragment() // Replace with your actual fragment class
    private val homeFragment = homeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_home)

        bookmarkButton = findViewById(R.id.bookmark_floatingbutton)


        val args = Bundle()
        args.putString("index", "hi")
        homeFragment.arguments = args

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .commit()

        bookmarkButton.setOnClickListener {
            replaceFragment(bookFragment)
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack("bookmarks")
            .commit()

        supportFragmentManager.registerFragmentLifecycleCallbacks(object: FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentCreated(
                fm: FragmentManager,
                f: Fragment,
                savedInstanceState: Bundle?
            ) {
                super.onFragmentCreated(fm, f, savedInstanceState)
                super.onFragmentPaused(fm, f)
                println("created")
                bookmarkButton.hide()
            }

            override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
                super.onFragmentDestroyed(fm, f)
                println("destroyed")
                bookmarkButton.show()
            }
        }, true)
    }
}
