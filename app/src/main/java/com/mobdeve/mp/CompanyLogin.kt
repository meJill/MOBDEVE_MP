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
        company_id = findViewById(R.id.companyL_name)
        company_password = findViewById(R.id.companyL_password)



        companySignInButton.setOnClickListener{
            val name = company_id.text.toString()
            val password = company_password.text.toString()
            // Check if both username and password fields are not empty
            if (name.isNotEmpty() && password.isNotEmpty()) {
                //val message = "Username: $name\nPassword: $password"
                //showToast(message)

            } else {
                showToast("Please enter both username and password")
            }
        }

        companySignUpButton.setOnClickListener {
            val intent = Intent(this, CompanySignUp::class.java)
            startActivity(intent)
        }

        companySignInButton.setOnClickListener {
            val dbHelper = MyDatabaseHelper(this)
            if (dbHelper.isCompanyUsernamePasswordMatch(findViewById<EditText>(R.id.companyL_name).text.toString(), findViewById<EditText>(R.id.companyL_password).text.toString())) {
                println("it worked")
            } else
                println("no it didnt")
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}