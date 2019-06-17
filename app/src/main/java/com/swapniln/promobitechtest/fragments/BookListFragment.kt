package com.swapniln.promobitechtest.fragments

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swapniln.promobitechtest.R


import com.swapniln.promobitechtest.adapters.BookAdapter
import com.swapniln.promobitechtest.models.BooksItem
import com.swapniln.promobitechtest.viewModels.BookListViewModel
import kotlinx.android.synthetic.main.book_list_fragment.*


import java.util.ArrayList

class BookListFragment : Fragment() {

    private var mViewModel: BookListViewModel? = null
    private var bookAdapter: BookAdapter? = null
    private var booksItems: ArrayList<BooksItem>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.book_list_fragment, container, false)

        // init viewModel
        mViewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        booksItems = ArrayList()
        bookAdapter = BookAdapter(booksItems!!)


        // using kotlinx synthetic for view binding
        rvBooksList.layoutManager = LinearLayoutManager(context)
        rvBooksList.setHasFixedSize(true)
        rvBooksList.adapter = bookAdapter
        refreshAdapter()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // observe books list with livedata and update db
        mViewModel!!.books.observe(this, Observer {
            it?.let {

                // insert book list db
                mViewModel!!.clearAndInsertBookListInDB(it.data!!.books!!)
            }
        })

    }

    private fun refreshAdapter() {

        // observe books list with livedata  from db and update UI
        mViewModel!!.allBookItemsFromDB.observe(this, Observer {

            it?.let {
                booksItems!!.clear()
                booksItems!!.addAll(it)
                bookAdapter!!.notifyDataSetChanged()
            }
        })

    }

    // get instance of BookListFragment
    companion object {
        fun newInstance(): BookListFragment {
            return BookListFragment()
        }
    }


}
