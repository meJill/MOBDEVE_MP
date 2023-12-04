package com.mobdeve.mp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.mp.Models.Job
import com.mobdeve.mp.Models.Student

private lateinit var reqs: EditText
private lateinit var CompanyAddJobButton: Button
class CompanyAdd: AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_req)

        reqs = findViewById(R.id.job_text_company)
        CompanyAddJobButton = findViewById(R.id.company_add_req)
        val name = intent.getStringExtra("Company_Name")


        CompanyAddJobButton.setOnClickListener {
            val postedReqs = reqs.text.toString()

            // Check if both username and password fields are not empty
            if (postedReqs.isNotEmpty()) {
                val job = Job(
                    companyId = 1,
                    company = name.toString(),
                    name = findViewById<EditText>(R.id.job_text_company).text.toString(),
                )


                val dbHelper = MyDatabaseHelper(this)
                dbHelper.addJob(job)
                val message = "Username: $reqs\n"
                showToast(message)
            } else {
                showToast("Please enter a name")
            }
        }

    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}