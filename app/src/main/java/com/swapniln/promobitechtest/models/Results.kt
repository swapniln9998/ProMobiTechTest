package com.swapniln.promobitechtest.models

import java.util.ArrayList
import com.google.gson.annotations.SerializedName
import com.swapniln.promobitechtest.models.BooksItem

class Results {

    @SerializedName("next_published_date")
    var nextPublishedDate: String? = null

    @SerializedName("bestsellers_date")
    var bestsellersDate: String? = null

    @SerializedName("books")
    var books: ArrayList<BooksItem>? = null

    @SerializedName("corrections")
    var corrections: List<Any>? = null

    @SerializedName("published_date_description")
    var publishedDateDescription: String? = null

    @SerializedName("normal_list_ends_at")
    var normalListEndsAt: Int = 0

    @SerializedName("list_name")
    var listName: String? = null

    @SerializedName("list_name_encoded")
    var listNameEncoded: String? = null

    @SerializedName("previous_published_date")
    var previousPublishedDate: String? = null

    @SerializedName("display_name")
    var displayName: String? = null

    @SerializedName("published_date")
    var publishedDate: String? = null

    @SerializedName("updated")
    var updated: String? = null


}