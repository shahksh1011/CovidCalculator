package com.example.kshitij.covidcalculator

import com.example.kshitij.covidcalculator.repositories.CovidUpdateRpository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
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

}

fun createApi() : NetworkApi{
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("http://covidtracking.com/api/us")
        .build()
    return retrofit.create(NetworkApi::class.java)
}
