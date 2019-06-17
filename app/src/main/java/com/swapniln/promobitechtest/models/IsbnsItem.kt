package com.swapniln.promobitechtest.models


import com.google.gson.annotations.SerializedName

class IsbnsItem {

    @SerializedName("isbn13")
    var isbn13: String? = null

    @SerializedName("isbn10")
    var isbn10: String? = null

}