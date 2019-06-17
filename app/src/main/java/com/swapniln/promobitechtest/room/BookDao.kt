package com.swapniln.promobitest.room


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.swapniln.promobitechtest.models.BooksItem

import java.util.ArrayList


@Dao
interface BookDao {

    @get:Query("SELECT * FROM booksitem ")
    val allBookItems: LiveData<List<BooksItem>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookItems(booksItems: ArrayList<BooksItem>)

    @Query("Delete from booksitem")
    fun deleteBookItems()
}
