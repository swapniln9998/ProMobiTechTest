package com.swapniln.promobitechtest.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.swapniln.promobitechtest.models.BooksItem
import com.swapniln.promobitechtest.models.Results
import com.swapniln.promobitechtest.reposiries.BookRepository
import com.swapniln.promobitechtest.retrofit.Resource

import java.util.ArrayList

class BookListViewModel(application: Application) : AndroidViewModel(application) {


    private val bookRepository: BookRepository = BookRepository(application)


    val books: LiveData<Resource<Results>>
        get() = bookRepository.bookFromServer


    val allBookItemsFromDB: LiveData<List<BooksItem>>
        get() = bookRepository.allBookItems

    fun clearAndInsertBookListInDB(booksItems: ArrayList<BooksItem>) {
        bookRepository.clearAndInsertMyVideosInDB(booksItems)
    }
}
