package com.mobdeve.mp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompanyDashboard : AppCompatActivity() {
    private var x1: Float = 0.toFloat()
    private var x2: Float = 0.toFloat()
    private val MIN_DISTANCE = 150
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CompanyAdapter
//    private val data: ArrayList<CompanyPostModel> = CompanyDataHelper.initializeData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_dashboard)

        val dbHelper = MyDatabaseHelper(this)
        val name = intent.getStringExtra("Company_Name")

        val jobNames = dbHelper.getAllJobNamesForCompany(name.toString())
        val data: ArrayList<CompanyPostModel>  = CompanyDataHelper.companyData(jobNames)

        recyclerView = findViewById(R.id.dashboard_RV)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CompanyAdapter(data, this, name.toString()) // Initialize your adapter here and pass your data if needed
        recyclerView.adapter = adapter

        // Call this function to show the dialog
        // showDialog()
    }

    override fun onRestart() {
        super.onRestart()

        this.recreate()
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Welcome")
        builder.setMessage("This is your company dashboard.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
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