package com.example.kshitij.covidcalculator.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kshitij.covidcalculator.R
import com.example.kshitij.covidcalculator.adapters.HealthClassAdapter
import com.example.kshitij.covidcalculator.data.Person
import com.example.kshitij.covidcalculator.data.PersonHealthData
import com.example.kshitij.covidcalculator.viewmodels.PersonGraphViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PersonGraph : AppCompatActivity() {

    private val newHealthRecordActivityCode = 5
    private lateinit var healthClassAdapter: HealthClassAdapter
    private lateinit var personGraphViewModel: PersonGraphViewModel
    private lateinit var personData: Person
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_graph)
//        val intent = Intent(this, MainActivity::class.java)
        val bundle = intent.getBundleExtra("Person")

        val person: Person = bundle.getSerializable("personData") as Person
        personData = person
        healthClassAdapter = HealthClassAdapter(this)
        personGraphViewModel = ViewModelProvider(this).get(PersonGraphViewModel::class.java)



        val personGraphRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_graph_view)
        personGraphRecyclerView.layoutManager = LinearLayoutManager(this)
        personGraphViewModel.healthRecords.observe(this, Observer { personHealthData->
            personHealthData?.let { healthClassAdapter.setHealthData(it) }
        })
        personGraphRecyclerView.adapter = healthClassAdapter
        val healthFabButton = findViewById<FloatingActionButton>(R.id.button_add_new_health_data)
        healthFabButton.setOnClickListener {
            val intent = Intent(this@PersonGraph, NewHealthRecord::class.java)
            val bundle: Bundle = Bundle()
            bundle.putSerializable("personData", person)
            intent.putExtra("Person", bundle)
            startActivityForResult(intent, newHealthRecordActivityCode)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == newHealthRecordActivityCode && resultCode == Activity.RESULT_OK){
            data?.let { d->
                val  bundle =d.getBundleExtra(NewHealthRecord.EXTRA_REPLY)
                val bodyTemp = bundle.getString("bodyTemp")
                val oxygenLevel = bundle.getString("oxygenLevel")

                val personHealthData = PersonHealthData(bodyTemp, oxygenLevel = oxygenLevel,
                    personId = personData.id )
                personGraphViewModel.insert(personHealthData)
                healthClassAdapter.notifyDataSetChanged()

            }
        }
    }
}



