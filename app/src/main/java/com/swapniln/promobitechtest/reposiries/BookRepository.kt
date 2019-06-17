package com.swapniln.promobitechtest.reposiries

import android.content.Context


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swapniln.promobitechtest.R

import com.swapniln.promobitechtest.database.AppDatabase
import com.swapniln.promobitechtest.models.BooksItem
import com.swapniln.promobitechtest.models.Response
import com.swapniln.promobitechtest.models.Results
import com.swapniln.promobitechtest.retrofit.APIClient
import com.swapniln.promobitechtest.retrofit.Resource
import com.swapniln.promobitechtest.retrofit.Webservices
import com.swapniln.promobitest.room.BookDao


import java.util.ArrayList

import io.reactivex.Completable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class BookRepository(private val mContext: Context) {

    private val bookDao: BookDao
    private val webservices: Webservices

    private var resourceMutableLiveBooks: MutableLiveData<Resource<Results>>? = null


    /* network api call for getting Book list*/ val bookFromServer: MutableLiveData<Resource<Results>>
        get() {

            if (resourceMutableLiveBooks == null) {
                resourceMutableLiveBooks = MutableLiveData()
            }


            webservices.getBooks(mContext.getString(R.string.api_key))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Observer<Response> {
                        override fun onSubscribe(d: Disposable) {

                        }

                        override fun onNext(response: Response) {

                            resourceMutableLiveBooks!!.setValue(Resource.success(response.results!!))
                        }

                        override fun onError(e: Throwable) {

                        }

                        override fun onComplete() {

                        }
                    })

            return resourceMutableLiveBooks as MutableLiveData<Resource<Results>>
        }

    val allBookItems: LiveData<List<BooksItem>>
        get() = bookDao.allBookItems

    init {
        val appDatabase = AppDatabase.getAppDatabase(mContext)
        this.bookDao = appDatabase.booksDao()
        webservices = APIClient.getClient()?.create(Webservices::class.java)!!
    }

    fun clearAndInsertMyVideosInDB(booksItems: ArrayList<BooksItem>) {
        val completableDelete = Completable.fromAction { bookDao.deleteBookItems() }
        val completableInsert = Completable.fromAction { bookDao.insertBookItems(booksItems) }

        completableDelete.andThen(completableInsert)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

}
