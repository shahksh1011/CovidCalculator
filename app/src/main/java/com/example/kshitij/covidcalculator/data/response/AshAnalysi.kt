package com.example.kshitij.covidcalculator.data.response


import com.google.gson.annotations.SerializedName

data class AshAnalysi(
    val countrycode: String,
    val date: String,
    val deaths: String
)