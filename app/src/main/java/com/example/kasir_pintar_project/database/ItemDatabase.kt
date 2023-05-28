package com.example.kasir_pintar_project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        private val LOCK = Any()
        private var INSTANCE: ItemDatabase? = null

        fun getDatabase(context: Context): ItemDatabase =
            INSTANCE ?: synchronized(LOCK) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "itemDB"
                ).createFromAsset("itemDB.db").build()
                INSTANCE = instance
                instance
            }
    }
}