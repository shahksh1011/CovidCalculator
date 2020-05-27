package com.example.kshitij.covidcalculator.utilities

import androidx.room.TypeConverter
import java.util.*

class Converter {
    companion object{
        @TypeConverter
        @JvmStatic
        fun fromDate(date: Date):Long{
            return date.time
        }
    }
}