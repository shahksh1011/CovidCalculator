package com.example.kshitij.covidcalculator.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kshitij.covidcalculator.data.response.CovidUpdateDataItem
import com.example.kshitij.covidcalculator.repositories.CovidUpdateRpository
import org.koin.core.KoinComponent

class CovidCasesViewModel (val covidUpdateRpository: CovidUpdateRpository): ViewModel(), KoinComponent{
    var listOfUpdates = MutableLiveData<List<CovidUpdateDataItem>>()
    init{
        listOfUpdates.value = listOf()
    }
    fun getAllData(){
        covidUpdateRpository.getCovidUpdates(object : CovidUpdateRpository.OnUpdateData{
            override fun onSuccess(data: List<CovidUpdateDataItem>) {
                listOfUpdates.value = data
            }

            override fun onFailure() {
                Log.d("APICALL", "FALED")
            }

        })
    }
}