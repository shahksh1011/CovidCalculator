package com.example.kshitij.covidcalculator.data.response


import com.google.gson.annotations.SerializedName

data class CovidUpdateDataItem(
    @SerializedName("ash analysis")
    val ashAnalysis: List<AshAnalysi>,
    val `data`: List<Data>,
    @SerializedName("GB data saved")
    val gBDataSaved: List<GBDataSaved>,
    val tokens: List<String>
)