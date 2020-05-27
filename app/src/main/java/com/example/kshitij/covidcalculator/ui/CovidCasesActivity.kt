package com.example.kshitij.covidcalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kshitij.covidcalculator.R
import com.example.kshitij.covidcalculator.adapters.CovidCasesAdapter
import com.example.kshitij.covidcalculator.data.response.CovidUpdateDataItem
import com.example.kshitij.covidcalculator.viewmodels.CovidCasesViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class CovidCasesActivity : AppCompatActivity() {

    private val covidViewModel: CovidCasesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_cases)

        val recyclerView = findViewById<RecyclerView>(R.id.covid_cases_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        covidViewModel.getAllData()
        covidViewModel.listOfUpdates.observe(this, Observer(function = fun(updateList: CovidUpdateDataItem?){
            updateList?.let {
                var covidUpdateAdapter = CovidCasesAdapter(this, updateList.data)
                recyclerView.adapter = covidUpdateAdapter
            }
        }))
    }
}
