package com.example.kshitij.covidcalculator.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "covid_table")
data class Person(

    val firstName: String,
    val lastName: String,
    val age: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}