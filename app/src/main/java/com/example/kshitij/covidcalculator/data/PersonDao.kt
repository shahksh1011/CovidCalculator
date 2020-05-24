package com.example.kshitij.covidcalculator.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface PersonDao {
    @Query("SELECT * from covid_table ORDER BY firstName ASC")
    fun getAllPeople():LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(person: Person)

    @Query("DELETE FROM covid_table")
    fun deleteAll()
}