package com.mobdeve.mp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.mp.Models.Company


class CompanyEdit: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_edit)

        val intentId = intent.getIntExtra("Company_Id", -1)
        val dbHelper = MyDatabaseHelper(this)
        val company = dbHelper.getCompanyById(intentId)

        findViewById<EditText>(R.id.companyE_name).setText(company?.name.toString())
        findViewById<EditText>(R.id.companyE_password).setText(company?.password.toString())
        findViewById<EditText>(R.id.companyE_address).setText(company?.address.toString())
        findViewById<EditText>(R.id.companyE_contact_number).setText(company?.contact.toString())
        findViewById<EditText>(R.id.companyE_email).setText(company?.email.toString())

        var saveButton: Button = findViewById(R.id.companyE_save)
        var cancelButton: Button = findViewById(R.id.companyE_cancel)

        saveButton.setOnClickListener {
            if (emptyCheck()) {
                showToast("Please fill up all the blanks")
            } else {
                val company = Company(
                    id = intentId,
                    name = findViewById<EditText>(R.id.companyE_name).text.toString(),
                    password = findViewById<EditText>(R.id.companyE_password).text.toString(),
                    address = findViewById<EditText>(R.id.companyE_address).text.toString(),
                    contact = findViewById<EditText>(R.id.companyE_contact_number).text.toString(),
                    email = findViewById<EditText>(R.id.companyE_email).text.toString()
                )
                dbHelper.editCompany(company)
            }
            finish()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun emptyCheck (): Boolean {
        return (findViewById<EditText>(R.id.companyE_name).text.toString().isEmpty() ||
                findViewById<EditText>(R.id.companyE_password).text.toString().isEmpty() ||
                findViewById<EditText>(R.id.companyE_address).text.toString().isEmpty() ||
                findViewById<EditText>(R.id.companyE_contact_number).text.toString().isEmpty() ||
                findViewById<EditText>(R.id.companyE_email).text.toString().isEmpty())
    }
}