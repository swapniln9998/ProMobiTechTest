package com.swapniln.promobitechtest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.swapniln.promobitechtest.R
import com.swapniln.promobitechtest.models.BooksItem


class  BookAdapter (var booksItem: List<BooksItem>) : RecyclerView.Adapter<BookViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {


        // create layout inflater
        val inflater = LayoutInflater.from(parent.context)

        return BookViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
        return booksItem.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        return holder.bind(booksItem[position])

    }

}

class BookViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_book,parent,false))
{
     private var tvAuthor: TextView? = null
     private var tvBookTitle: TextView? = null
     private var tvDescription: TextView? = null
     private var ivBookImage: ImageView? = null
    init {

        tvAuthor = itemView.findViewById(R.id.tvAuthor)
        tvBookTitle = itemView.findViewById(R.id.tvBookTitle)
        tvDescription = itemView.findViewById(R.id.tvDescription)
        ivBookImage = itemView.findViewById(R.id.ivBookImage)

    }

    // bind data to view holder

    fun bind(booksItem: BooksItem)
    {
        tvBookTitle?.text = booksItem.title
        tvAuthor?.text = booksItem.author
        tvDescription?.text = booksItem.description

        ivBookImage?.let {
            Glide.with(itemView.context)
                .load(booksItem.bookImage)
                .into(it)
        }

    }
}

