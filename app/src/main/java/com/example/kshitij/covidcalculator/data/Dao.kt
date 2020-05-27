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

@Dao
interface PersonHealthDao{
    @Query
    ("SELECT * from covid_health_entry_table WHERE recordId LIKE :personId")
    fun getAllHealthData(personId: Int):LiveData<List<PersonHealthData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(personHealthData: PersonHealthData)

    @Query("DELETE FROM covid_health_entry_table")
    fun deleteAll()
}