package com.example.kshitij.covidcalculator.repositories

import com.example.kshitij.covidcalculator.NetworkApi
import com.example.kshitij.covidcalculator.data.response.CovidUpdateDataItem

import retrofit2.Call
import retrofit2.Response

class CovidUpdateRpository (val networkApi: NetworkApi){

    fun getCovidUpdates(onUpdateData: OnUpdateData) {
        networkApi.getCovidUpdates().enqueue(object : retrofit2.Callback<List<CovidUpdateDataItem>> {
            override fun onFailure(call: Call<List<CovidUpdateDataItem>>, t: Throwable) {
                onUpdateData.onFailure()
            }

            override fun onResponse(
                call: Call<List<CovidUpdateDataItem>>,
                response: Response<List<CovidUpdateDataItem>>
            ) {
                onUpdateData.onSuccess(response.body() as List<CovidUpdateDataItem>)
            }

        })
    }
    interface OnUpdateData {
        fun onSuccess(data: List<CovidUpdateDataItem>)
        fun onFailure()
    }
}


