package com.example.kshitij.covidcalculator.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.kshitij.covidcalculator.data.Person
import com.example.kshitij.covidcalculator.data.PersonDao

class PersonRepository(private val personDao: PersonDao) {
    val allPeople: LiveData<List<Person>> = personDao.getAllPeople()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(person: Person){
        personDao.insert(person)
    }
}