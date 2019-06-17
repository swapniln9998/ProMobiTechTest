package com.swapniln.promobitechtest.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.swapniln.promobitechtest.room.convertor.Converters

@Entity
class BooksItem {


    @SerializedName("isbns")
    @TypeConverters(Converters::class)
    var isbns: List<IsbnsItem>? = null

    @SerializedName("contributor_note")
    var contributorNote: String? = null

    @SerializedName("asterisk")
    var asterisk: Int = 0

    @SerializedName("description")
    var description: String? = null

    @SerializedName("primary_isbn10")
    var primaryIsbn10: String? = null

    @SerializedName("primary_isbn13")
    var primaryIsbn13: String? = null

    @PrimaryKey
    @SerializedName("title")
    lateinit var title: String

    @SerializedName("weeks_on_list")
    var weeksOnList: Int = 0

    @SerializedName("article_chapter_link")
    var articleChapterLink: String? = null

    @SerializedName("book_image_width")
    var bookImageWidth: Int = 0

    @SerializedName("contributor")
    var contributor: String? = null

    @SerializedName("amazon_product_url")
    var amazonProductUrl: String? = null

    @SerializedName("price")
    var price: Int = 0

    @SerializedName("rank")
    var rank: Int = 0

    @SerializedName("dagger")
    var dagger: Int = 0

    @SerializedName("author")
    var author: String? = null

    @SerializedName("age_group")
    var ageGroup: String? = null


    @SerializedName("buy_links")
    @TypeConverters(Converters::class)
    var buyLinks: List<BuyLinksItem>? = null

    @SerializedName("sunday_review_link")
    var sundayReviewLink: String? = null

    @SerializedName("book_review_link")
    var bookReviewLink: String? = null

    @SerializedName("book_image_height")
    var bookImageHeight: Int = 0

    @SerializedName("book_image")
    var bookImage: String? = null

    @SerializedName("publisher")
    var publisher: String? = null

    @SerializedName("rank_last_week")
    var rankLastWeek: Int = 0

    @SerializedName("first_chapter_link")
    var firstChapterLink: String? = null

}