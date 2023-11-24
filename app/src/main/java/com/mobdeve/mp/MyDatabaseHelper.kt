package com.mobdeve.mp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import com.mobdeve.mp.Models.Company
import com.mobdeve.mp.Models.Job
import com.mobdeve.mp.Models.Student

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "mydatabase"
        private const val DATABASE_VERSION = 3
    }

    // Define the columns for the Job table
    private val createJobTableQuery = """
        CREATE TABLE IF NOT EXISTS Job (
            companyId INTEGER PRIMARY KEY AUTOINCREMENT,
            company TEXT,
            name TEXT
        );
    """.trimIndent()

    // Define the columns for the Student table
    private val createStudentTableQuery = """
        CREATE TABLE IF NOT EXISTS Student (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            password TEXT,
            bookmarks TEXT  -- Assuming you store bookmarks as a JSON string
        );
    """.trimIndent()

    // Define the columns for the Company table
    private val createCompanyTableQuery = """
        CREATE TABLE IF NOT EXISTS Company (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            password TEXT,
            address TEXT,
            email TEXT,
            contact TEXT
        );
    """.trimIndent()

    override fun onCreate(db: SQLiteDatabase) {
        // Create the tables
        db.execSQL(createJobTableQuery)
        db.execSQL(createStudentTableQuery)
        db.execSQL(createCompanyTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database upgrades here
        db.execSQL("DROP TABLE IF EXISTS Job")
        db.execSQL("DROP TABLE IF EXISTS Student")
        db.execSQL("DROP TABLE IF EXISTS Company")
        onCreate(db)
    }

    fun addStudent(student: Student): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", student.name)
            put("password", student.password)
            // Assuming bookmarks are stored as a JSON string for simplicity
            put("bookmarks", student.bookmarks.toString())
        }

        // Insert the new row, returning the primary key value of the new row
        val newRowId = db.insert("Student", null, values)

        // Close the database
        db.close()

        return newRowId
    }

    fun isStudentUsernameExists(username: String): Boolean {
        val db = readableDatabase
        val selection = "name = ?"
        val selectionArgs = arrayOf(username)

        val cursor = db.query(
            "Student",   // The table to query
            null,        // The array of columns to return (null means all columns)
            selection,   // The columns for the WHERE clause
            selectionArgs, // The values for the WHERE clause
            null,        // don't group the rows
            null,        // don't filter by row groups
            null         // don't sort the order
        )

        val usernameExists = cursor.moveToFirst()
        cursor.close()
        db.close()

        return usernameExists
    }

    fun isUsernamePasswordMatch(username: String, password: String): Boolean {
        val db = readableDatabase
        val selection = "name = ? AND password = ?"
        val selectionArgs = arrayOf(username, password)

        val cursor = db.query(
            "Student",   // The table to query
            null,        // The array of columns to return (null means all columns)
            selection,   // The columns for the WHERE clause
            selectionArgs, // The values for the WHERE clause
            null,        // don't group the rows
            null,        // don't filter by row groups
            null         // don't sort the order
        )

        val matchFound = cursor.moveToFirst()
        cursor.close()
        db.close()

        return matchFound
    }

    fun addCompany(company: Company): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", company.name)
            put("password", company.password)
            put("address", company.address)
            put("contact", company.contact)
            put("email", company.email)
        }

        // Insert the new row, returning the primary key value of the new row
        val newRowId = db.insert("Company", null, values)

        // Close the database
        db.close()

        return newRowId
    }

    fun getAllJobNamesForCompany(companyName: String): ArrayList<String> {
        val jobNames = ArrayList<String>()
        val db = readableDatabase
        val columns = arrayOf("name")
        val selection = "company = ?"
        val selectionArgs = arrayOf(companyName)

        // Query the Job table to get all job names for the specified company
        val cursor = db.query(
            "Job",
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        // Iterate through the cursor and add each job name to the array
        while (cursor.moveToNext()) {
            val nameIndex = cursor.getColumnIndex("name")
            val jobName = cursor.getString(nameIndex)
            jobNames.add(jobName)
        }

        // Close the cursor and the database
        cursor.close()
        db.close()

        return jobNames
    }

    fun getCompanyByName(companyName: String): Company? {
        val db = readableDatabase
        val columns = arrayOf("id", "name", "password", "address", "number", "email")
        val selection = "name = ?"
        val selectionArgs = arrayOf(companyName)

        // Query the Company table to get the company with the specified name
        val cursor = db.query(
            "Company",
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        // Check if the cursor has a row
        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex("id")
            val nameIndex = cursor.getColumnIndex("name")
            val passwordIndex = cursor.getColumnIndex("password")
            val addressIndex = cursor.getColumnIndex("address")
            val contactIndex = cursor.getColumnIndex("contact")
            val emailIndex = cursor.getColumnIndex("email")

            // Create a Company object with the retrieved data
            val company = Company(
                id = cursor.getInt(idIndex),
                name = cursor.getString(nameIndex),
                password = cursor.getString(passwordIndex),
                address = cursor.getString(addressIndex),
                contact = cursor.getString(contactIndex),
                email = cursor.getString(emailIndex)
            )

            // Close the cursor and the database
            cursor.close()
            db.close()

            return company
        } else {
            // No company found with the specified name
            // Close the cursor and the database
            cursor.close()
            db.close()

            return null
        }
    }

    fun isCompanyNameExist (name: String): Boolean {
        val db = readableDatabase
        val selection = "name = ?"
        val selectionArgs = arrayOf(name)

        val cursor = db.query(
            "Company",   // The table to query
            null,        // The array of columns to return (null means all columns)
            selection,   // The columns for the WHERE clause
            selectionArgs, // The values for the WHERE clause
            null,        // don't group the rows
            null,        // don't filter by row groups
            null         // don't sort the order
        )

        val nameExists = cursor.moveToFirst()
        cursor.close()
        db.close()

        return nameExists
    }

    fun editCompany(company: Company): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", company.name)
            put("password", company.password)
            put("address", company.address)
            put("contact", company.contact)
            put("email", company.email)
        }

        // Update the row, returning the number of rows affected
        val rowsAffected = db.update(
            "Company",
            values,
            "id = ?",
            arrayOf(company.id.toString())
        )

        // Close the database
        db.close()

        return rowsAffected
    }

    fun isCompanyUsernamePasswordMatch(username: String, password: String): Boolean {
        val db = readableDatabase
        val selection = "name = ? AND password = ?"
        val selectionArgs = arrayOf(username, password)

        val cursor = db.query(
            "Company",   // The table to query
            null,        // The array of columns to return (null means all columns)
            selection,   // The columns for the WHERE clause
            selectionArgs, // The values for the WHERE clause
            null,        // don't group the rows
            null,        // don't filter by row groups
            null         // don't sort the order
        )

        val matchFound = cursor.moveToFirst()
        cursor.close()
        db.close()

        return matchFound
    }

    fun deleteCompanyByName(companyName: String): Int {
        val db = writableDatabase
        val whereClause = "name = ?"
        val whereArgs = arrayOf(companyName)

        // Delete the row, returning the number of rows affected
        val rowsAffected = db.delete("Company", whereClause, whereArgs)

        // Close the database
        db.close()

        return rowsAffected
    }

    fun addJob(job: Job): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("company", job.company)
            put("name", job.name)
        }

        // Insert the new row, returning the primary key value of the new row
        val newRowId = db.insert("Job", null, values)

        // Close the database
        db.close()

        return newRowId
    }

    fun deleteJob(jobName: String, companyName: String): Int {
        val db = writableDatabase
        val whereClause = "name = ? AND company = ?"
        val whereArgs = arrayOf(jobName, companyName)

        // Delete
        val rowsAffected = db.delete("Job", whereClause, whereArgs)

        // Close the database
        db.close()

        return rowsAffected
    }


}