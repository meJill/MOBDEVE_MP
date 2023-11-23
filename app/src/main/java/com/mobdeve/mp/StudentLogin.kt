package com.mobdeve.mp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.fragments.bookFragment
import com.mobdeve.mp.fragments.homeFragment
private lateinit var bookmarkButton: FloatingActionButton
private val bookFragment = bookFragment()// Replace with your actual fragment class
class StudentLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_login)

//        bookmarkButton = findViewById(R.id.bookmark_floatingbutton)
//
//        bookmarkButton.setOnClickListener {
//            replaceFragment(bookFragment)
//        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(null)
            .commit()
    }
}