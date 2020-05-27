package com.example.kshitij.covidcalculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kshitij.covidcalculator.R
import com.example.kshitij.covidcalculator.adapters.HealthClassAdapter
import com.example.kshitij.covidcalculator.data.Person
import com.example.kshitij.covidcalculator.viewmodels.PersonGraphViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PersonGraph : AppCompatActivity() {

    private lateinit var healthClassAdapter: HealthClassAdapter
    private lateinit var personGraphViewModel: PersonGraphViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_graph)
//        val intent = Intent(this, MainActivity::class.java)
        val bundle = intent.getBundleExtra("Person")

        healthClassAdapter = HealthClassAdapter(this)
        personGraphViewModel = ViewModelProvider(this).get(PersonGraphViewModel::class.java)

        val person: Person = bundle.getSerializable("personData") as Person

        val personGraphRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_graph_view)
        personGraphRecyclerView.layoutManager = LinearLayoutManager(this)
        personGraphViewModel.healthRecords.observe(this, Observer { personHealthData->
            personHealthData?.let { healthClassAdapter.setHealthData(it) }
        })
        val healthFabButton = findViewById<FloatingActionButton>(R.id.button_add_new_health_data)
        healthFabButton.setOnClickListener {
            val intent = Intent(this@PersonGraph, NewHealthRecord::class.java)
            startActivity(intent)
        }
        Toast.makeText(applicationContext, "CLICJK - " + person.firstName, Toast.LENGTH_LONG).show()
    }
}



