package com.example.kshitij.covidcalculator.data.response


import com.google.gson.annotations.SerializedName

data class CovidUpdateDataItem(
    val checkTimeEt: String,
    val commercialScore: Int,
    val dataQualityGrade: String,
    val dateChecked: String,
    val dateModified: String,
    val death: Int,
    val fips: String,
    val grade: String,
    val hash: String,
    val hospitalized: Int,
    val hospitalizedCumulative: Int,
    val hospitalizedCurrently: Int,
    val inIcuCumulative: Int,
    val inIcuCurrently: Int,
    val lastUpdateEt: String,
    val negative: Int,
    val negativeRegularScore: Int,
    val negativeScore: Int,
    val notes: String,
    val onVentilatorCumulative: Int,
    val onVentilatorCurrently: Int,
    val pending: Int,
    val posNeg: Int,
    val positive: Int,
    val positiveScore: Int,
    val recovered: Int,
    val score: Int,
    val state: String,
    val total: Int,
    val totalTestResults: Int
)