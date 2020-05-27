package com.example.kshitij.covidcalculator.data

import androidx.room.*
import java.io.Serializable


@Entity(tableName = "covid_health_entry_table",
    foreignKeys = [
        ForeignKey(
            entity = Person::class,
            parentColumns = ["id"],
            childColumns = ["personId"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE)
    ]
)
data class PersonHealthData(

    val bodyTemperature: String?,
    val oxygenLevel: String?,
    val personId: Int
//    val date: java.util.Date?=null

): Serializable{
    @PrimaryKey(autoGenerate = true)
    var recordId: Int = 0
}
