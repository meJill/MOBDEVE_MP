package com.mobdeve.mp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.fragments.bookFragment // Ensure correct import for your BookFragment

class StudentHome : AppCompatActivity() {
    private lateinit var bookmarkButton: FloatingActionButton
    private val bookFragment = bookFragment() // Replace with your actual fragment class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_home)

        bookmarkButton = findViewById(R.id.bookmark_floatingbutton)

        bookmarkButton.setOnClickListener {
            replaceFragment(bookFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(null)
            .commit()

        supportFragmentManager.registerFragmentLifecycleCallbacks(object: FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                super.onFragmentPaused(fm, f)
                println("paused")
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
