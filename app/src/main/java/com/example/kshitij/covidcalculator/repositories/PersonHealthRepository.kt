package com.example.kshitij.covidcalculator.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.kshitij.covidcalculator.data.PersonHealthDao
import com.example.kshitij.covidcalculator.data.PersonHealthData

class PersonHealthRepository(private val personHealthDao: PersonHealthDao){
    val allHealth: LiveData<List<PersonHealthData>> = personHealthDao.getAllHealthData()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(personHealthData: PersonHealthData){
        personHealthDao.insert(personHealthData)
    }
}