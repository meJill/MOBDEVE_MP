package com.mobdeve.mp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.mp.Models.Company

class CompanySignUp : AppCompatActivity() {
    private lateinit var signup: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_companies_signup)

        signup = findViewById(R.id.companyS_signup)
        signup?.setOnClickListener {
            val company = Company(
                id = 1,
                name = findViewById<EditText>(R.id.companyS_name).text.toString(),
                password = findViewById<EditText>(R.id.companyS_password).text.toString(),
                address = findViewById<EditText>(R.id.companyS_address).text.toString(),
                contact = findViewById<EditText>(R.id.companyS_contact_number).text.toString(),
                email = findViewById<EditText>(R.id.companyS_email).text.toString()
            )

            val dbHelper = MyDatabaseHelper(this)

            if (emptyCheck()) {
                showToast("Please fill up all the blanks")
            }
            else if (!dbHelper.isCompanyNameExist(findViewById<EditText>(R.id.companyS_name).text.toString())) {
                // Add the company to the database
                val newRowId = dbHelper.addCompany(company)

                // Check the result
                if (newRowId != -1L) {
                    // The student was added successfully
                    println("Student added with ID: $newRowId $company")
                } else {
                    // There was an error
                    println("Error adding company to the database")
                }
                finish()
            } else {
                showToast("Please use another name")
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun emptyCheck (): Boolean {
        return (findViewById<EditText>(R.id.companyS_name).text.toString().isEmpty() ||
                findViewById<EditText>(R.id.companyS_password).text.toString().isEmpty() ||
                findViewById<EditText>(R.id.companyS_address).text.toString().isEmpty() ||
                findViewById<EditText>(R.id.companyS_contact_number).text.toString().isEmpty() ||
                findViewById<EditText>(R.id.companyS_email).text.toString().isEmpty())
    }
}