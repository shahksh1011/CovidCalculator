package com.example.kshitij.covidcalculator.viewmodels


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kshitij.covidcalculator.data.response.CovidUpdateDataItem
import com.example.kshitij.covidcalculator.repositories.CovidUpdateRpository

import org.koin.standalone.KoinComponent


class CovidCasesViewModel(val covidUpdateRpository: CovidUpdateRpository): ViewModel(),
    KoinComponent {
    var listOfUpdates = MutableLiveData<CovidUpdateDataItem>()
    init{
//        listOfUpdates.value = listO
    }
    fun getAllData(){
        covidUpdateRpository.getCovidUpdates(object : CovidUpdateRpository.OnUpdateData{
            override fun onSuccess(data: CovidUpdateDataItem) {
                listOfUpdates.value = data
                Log.d("Data", data.toString())
            }

            override fun onFailure() {
                Log.d("APICALL", "FALED")
            }

        })
    }
}