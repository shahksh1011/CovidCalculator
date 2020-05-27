package com.example.kshitij.covidcalculator.repositories

import com.example.kshitij.covidcalculator.NetworkApi
import com.example.kshitij.covidcalculator.data.response.CovidUpdateDataItem
import retrofit2.Call
import retrofit2.Response

class CovidUpdateRpository (val networkApi: NetworkApi){

    fun getCovidUpdates(onUpdateData: OnUpdateData) {
        networkApi.getCovidUpdates().enqueue(object : retrofit2.Callback<CovidUpdateDataItem> {
            override fun onFailure(call: Call<CovidUpdateDataItem>, t: Throwable) {
                onUpdateData.onFailure()
            }

            override fun onResponse(
                call: Call<CovidUpdateDataItem>,
                response: Response<CovidUpdateDataItem>
            ) {
                onUpdateData.onSuccess(response.body() as CovidUpdateDataItem)
            }

        })
    }
    interface OnUpdateData {
        fun onSuccess(data:CovidUpdateDataItem)
        fun onFailure()
    }
}


