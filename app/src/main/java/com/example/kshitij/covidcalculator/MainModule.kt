package com.example.kshitij.covidcalculator

import com.example.kshitij.covidcalculator.repositories.CovidUpdateRpository
import com.example.kshitij.covidcalculator.viewmodels.CovidCasesViewModel

import org.koin.android.viewmodel.ext.koin.viewModel

import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
val mainModule = module {
    single {
        CovidUpdateRpository(get())
    }
    single {
        createApi()
    }
    viewModel {
        CovidCasesViewModel(get())
    }
}

fun createApi() : NetworkApi{
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://thevirustracker.com")
        .build()
    return retrofit.create(NetworkApi::class.java)
}
