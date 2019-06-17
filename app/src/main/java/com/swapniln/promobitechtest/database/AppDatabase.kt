package com.swapniln.promobitechtest.database


import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.swapniln.promobitechtest.models.BooksItem
import com.swapniln.promobitest.room.BookDao




@Database(entities = arrayOf(BooksItem::class), version = 1 ,exportSchema = false)
 abstract class AppDatabase : RoomDatabase() {

    abstract fun booksDao(): BookDao

    // singletone object of AppDatabase

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user-database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}