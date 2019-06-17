package com.swapniln.promobitechtest.retrofit

import com.swapniln.promobitechtest.models.Response

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Webservices {

    @GET("svc/books/v3/lists/current/hardcover-fiction.json")
    fun getBooks(@Query("api-key") query: String): Observable<Response>

}
