package com.swapniln.promobitechtest.room.convertor


import androidx.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swapniln.promobitechtest.models.BuyLinksItem
import com.swapniln.promobitechtest.models.IsbnsItem

import java.util.ArrayList


 object Converters {

    @TypeConverter
    @JvmStatic
    fun fromIsbns(value: String): List<IsbnsItem>? {
        val listType = object : TypeToken<List<IsbnsItem>>() {

        }.type
        return Gson().fromJson<List<IsbnsItem>>(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun toArrayListInbns(list: List<IsbnsItem>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    @JvmStatic
    fun fromBuyLinks(value: String): List<BuyLinksItem>? {
        val listType = object : TypeToken<ArrayList<IsbnsItem>>() {

        }.type
        return Gson().fromJson<List<BuyLinksItem>>(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun toArrayListBuyLinks(list: List<BuyLinksItem>): String {
        val gson = Gson()
        return gson.toJson(list)
    }


}
