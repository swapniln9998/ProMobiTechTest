package com.swapniln.promobitechtest.models


import com.google.gson.annotations.SerializedName


class Response {

    @SerializedName("copyright")
    var copyright: String? = null

    @SerializedName("last_modified")
    var lastModified: String? = null

    @SerializedName("results")
    var results: Results? = null

    @SerializedName("num_results")
    var numResults: Int = 0

    @SerializedName("status")
    var status: String? = null

}