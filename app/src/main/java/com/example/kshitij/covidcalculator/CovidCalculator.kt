package com.example.kshitij.covidcalculator

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.android.ext.koin.androidContext

class CovidCalculator: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this,
            listOf(mainModule),
            loadPropertiesFromFile = true)
    }
}
