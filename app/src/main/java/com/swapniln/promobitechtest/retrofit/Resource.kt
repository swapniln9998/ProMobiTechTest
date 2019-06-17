package com.swapniln.promobitechtest.retrofit

// A generic class that contains data and status about loading this data.
class Resource<T> private constructor(private val status: Status, val data: T?,
                                      private val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
