package com.example.kshitij.covidcalculator.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "covid_health_entry_table")
data class PersonHealthData (
    @PrimaryKey
    val personId:Int,
    val bodyTemperature: Int,
    val oxygenLevel: Int
)