package com.swapniln.promobitechtest.activities

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.swapniln.promobitechtest.R

import com.swapniln.promobitechtest.fragments.BookListFragment

class BookListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, BookListFragment.newInstance())
                    .commitNow()
        }
    }
}
