package com.example.kshitij.covidcalculator.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kshitij.covidcalculator.data.Person
import com.example.kshitij.covidcalculator.data.PersonDatabase
import com.example.kshitij.covidcalculator.repositories.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel(application: Application): AndroidViewModel(application){
    private val repository: PersonRepository
    val listOfPeople : LiveData<List<Person>>
    init {
        val personDao= PersonDatabase.getDatabase(application, viewModelScope).PersonDao()
        repository = PersonRepository(personDao)
        listOfPeople = repository.allPeople
    }
    fun insert(person: Person) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(person)
    }
}