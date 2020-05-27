package com.example.kshitij.covidcalculator.ui

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kshitij.covidcalculator.R
import com.example.kshitij.covidcalculator.adapters.PersonClassAdaper
import com.example.kshitij.covidcalculator.data.Person
import com.example.kshitij.covidcalculator.mainModule
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.ext.koin.androidContext


class MainActivity : AppCompatActivity(), PersonClassAdaper.itemcClickListener {

    private val newPersonActivityCode = 1
    private lateinit var personClassAdaper: PersonClassAdaper
    private lateinit var personViewModel: PersonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_activity_recycler_View)
        personClassAdaper = PersonClassAdaper(this, this)

        recyclerView.adapter = personClassAdaper
        recyclerView.layoutManager = LinearLayoutManager(this)

        personViewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        personViewModel.listOfPeople.observe(this, Observer { person->
            person?.let { personClassAdaper.setPeople(it) }

        })
        val fab = findViewById<FloatingActionButton>(R.id.floating_button_add_person)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewPersonActivity::class.java)
            startActivityForResult(intent, newPersonActivityCode)
        }
        val covidCaseButton = findViewById<Button>(R.id.button_covid_cases_us)
        covidCaseButton.setOnClickListener {
            val covidIntent = Intent(this@MainActivity, CovidCasesActivity::class.java)
            startActivity(covidIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == newPersonActivityCode && resultCode == Activity.RESULT_OK){
            data?.let { d->
//                val Person = Person(it.)
                val bundle: Bundle= d.getBundleExtra(NewPersonActivity.EXTRA_REPLY)
                val firstName = bundle.getString("firstName")
                val lastName = bundle.getString("lastName")
                val age = bundle.getString("age")
                val person = Person(firstName.toString(), lastName.toString(), age.toString())
                personViewModel.insert(person)
                personClassAdaper.notifyDataSetChanged()
            }
        }else{
            Toast.makeText(
                applicationContext,
                "Fill out all the fields",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onItemClicked(person: Person) {

        val intent = Intent(this, PersonGraph::class.java)
        val bundle: Bundle = Bundle()
        bundle.putSerializable("personData", person)
        intent.putExtra("Person", bundle)
        startActivity(intent)
    }

}
