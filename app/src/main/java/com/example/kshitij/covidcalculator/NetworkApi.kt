package com.example.kshitij.covidcalculator


import com.example.kshitij.covidcalculator.data.response.CovidUpdateDataItem
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {

    @GET("/timeline/map-data.json")
    fun getCovidUpdates(): Call<CovidUpdateDataItem>

}