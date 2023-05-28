package com.example.kasir_pintar_project.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

//class DatabaseHelper (private val context : Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
//    companion object {
//        private const val DATABASE_NAME = "itemDB.db"
//        private const val DATABASE_VERSION = 1
//        private const val DB_PATH = "/data/data/com.example.kasir_pintar_project/database/"
//    }
//
//    private var database: SQLiteDatabase? = null
//
//    init {
//        val dbExist = checkDatabase()
//        if (dbExist) {
//            openDatabase()
//        } else {
//            createDatabase()
//        }
//    }
//
//    private fun checkDatabase(): Boolean {
//        val dbFile = context.getDatabasePath(DATABASE_NAME)
//        return dbFile.exists()
//    }
//
//    private fun createDatabase() {
//        this.readableDatabase
//        try {
//            copyDatabase()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//
//    private fun copyDatabase() {
//        val inputStream: InputStream = context.assets.open(DATABASE_NAME)
//        val outputFile = DB_PATH + DATABASE_NAME
//        val outputStream: OutputStream = FileOutputStream(outputFile)
//        val buffer = ByteArray(1024)
//        var length: Int
//        while (inputStream.read(buffer).also { length = it } > 0) {
//            outputStream.write(buffer, 0, length)
//        }
//        outputStream.flush()
//        outputStream.close()
//        inputStream.close()
//    }
//
//    private fun openDatabase() {
//        val dbPath = DB_PATH + DATABASE_NAME
//        database = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE)
//    }
//
//    override fun onCreate(db: SQLiteDatabase) {}
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
//
//    fun getDatabase(): SQLiteDatabase? {
//        return database
//    }
//}