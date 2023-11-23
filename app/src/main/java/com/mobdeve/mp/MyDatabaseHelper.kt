package com.mobdeve.mp
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "mydatabase"
        private const val DATABASE_VERSION = 1
    }

    // Define the columns for the Job table
    private val createJobTableQuery = """
        CREATE TABLE IF NOT EXISTS Job (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
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
            email TEXT,
            contact INTEGER
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
}