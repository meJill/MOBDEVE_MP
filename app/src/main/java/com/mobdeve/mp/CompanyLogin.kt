package com.mobdeve.mp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CompanyLogin : AppCompatActivity() {
    private var x1: Float = 0.toFloat()
    private var x2: Float = 0.toFloat()
    private val MIN_DISTANCE = 150

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_login)

        val companySignInButton: Button = findViewById(R.id.sign_in_companies)
        val companySignUpButton: Button = findViewById(R.id.sign_up_companies)

        companySignUpButton.setOnClickListener {
            val intent = Intent(this, CompanySignUp::class.java)
            startActivity(intent)
        }

        companySignInButton.setOnClickListener {
            val dbHelper = MyDatabaseHelper(this)
            if (dbHelper.isCompanyUsernamePasswordMatch(
                    findViewById<EditText>(R.id.companyL_name).text.toString(),
                    findViewById<EditText>(R.id.companyL_password).text.toString()
                )
            ) {
                println("it worked")
                val intent = Intent(this, CompanyHome::class.java)
                val id =
                    dbHelper.getCompanyByName(findViewById<EditText>(R.id.companyL_name).text.toString())?.id
                intent.putExtra("Company_Id", id)
                startActivity(intent)
            } else
                println("no it didn't")
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> x1 = event.x
            MotionEvent.ACTION_UP -> {
                x2 = event.x
                val deltaX = x2 - x1
                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    if (x2 > x1) {
                        onBackPressed()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }
}
