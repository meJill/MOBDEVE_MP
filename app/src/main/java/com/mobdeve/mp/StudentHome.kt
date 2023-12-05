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

        val name = intent.getStringExtra("sName").toString()
        val args = Bundle()
        args.putString("name", name)
        homeFragment.arguments = args

        supportFragmentManager.registerFragmentLifecycleCallbacks(object: FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                if (f is homeFragment) {
                    super.onFragmentResumed(fm, f)
                    println("resumed")
                    bookmarkButton.show()
                }
            }
        }, false)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .commit()

        bookmarkButton.setOnClickListener {
            replaceFragment(bookFragment, args)
        }
    }


    private fun replaceFragment(fragment: Fragment, args: Bundle) {
        fragment.arguments = args

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack("bookmark")
            .commit()
        bookmarkButton.hide()
    }
}
