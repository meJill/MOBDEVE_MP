package com.mobdeve.mp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
private lateinit var companySignInButton: Button
private lateinit var companySignUpButton: Button
private lateinit var company_id: EditText
private lateinit var company_password: EditText
class CompanyLogin : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_login)

        companySignInButton = findViewById(R.id.sign_in_companies)
        companySignUpButton = findViewById(R.id.sign_up_companies)
        company_id = findViewById(R.id.company_id)
        company_password = findViewById(R.id.company_password)



        companySignInButton.setOnClickListener{
            val username = company_id.text.toString()
            val password = company_password.text.toString()
            // Check if both username and password fields are not empty
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val message = "Username: $username\nPassword: $password"
                showToast(message)
            } else {
                showToast("Please enter both username and password")
            }
        }

        companySignUpButton.setOnClickListener {
            val intent = Intent(this, CompanySignUp::class.java)
            startActivity(intent)
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}