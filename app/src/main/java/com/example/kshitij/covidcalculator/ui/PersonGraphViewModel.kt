package com.example.kshitij.covidcalculator.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kshitij.covidcalculator.data.PersonDatabase
import com.example.kshitij.covidcalculator.data.PersonHealthData
import com.example.kshitij.covidcalculator.repositories.PersonHealthRepository
import com.example.kshitij.covidcalculator.repositories.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonGraphViewModel(application: Application): AndroidViewModel(application){
    private val repository: PersonHealthRepository
    val healthRecords : LiveData<List<PersonHealthData>>
    init {
        val personHealthDao = PersonDatabase.getDatabase(application, viewModelScope).PersonHealthDao()
        repository = PersonHealthRepository(personHealthDao)
        healthRecords = repository.allHealth
    }
    fun insert(personHealthData: PersonHealthData) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(personHealthData)
    }
}