package com.example.kshitij.covidcalculator.data

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Person::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun PersonHealthDao() : PersonHealthDao

    abstract fun PersonDao():PersonDao
    companion object{
        @Volatile
        private var INSTANCE: PersonDatabase? = null
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PersonDatabase{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDatabase::class.java,
                    "covid_database"

                )
                    .fallbackToDestructiveMigration()
                    .addCallback(PersonDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }



        private class PersonDatabaseCallback(
            private val scope:CoroutineScope
        ): RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
//                        populateDatabase(database.PersonDao())
//                        Log.d(":d", "D")
                    }
                }

            }

        }
//        fun populateDatabase(personDao: PersonDao){
//            personDao.deleteAll()
//
//        }
    }
}