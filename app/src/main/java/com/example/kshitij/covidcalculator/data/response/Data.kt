package com.example.kshitij.covidcalculator.data.response


import com.google.gson.annotations.SerializedName

data class Data(
    val cases: String,
    val countrycode: String,
    val date: String,
    val deaths: String,
    val recovered: String
)