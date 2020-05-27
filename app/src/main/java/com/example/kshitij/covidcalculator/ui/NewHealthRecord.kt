package com.example.kshitij.covidcalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kshitij.covidcalculator.R
import java.util.*

class NewHealthRecord : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_health_record)
        val submitButton  = findViewById<Button>(R.id.button_submit)
        submitButton.setOnClickListener {
            val currTime = Date()
            Toast.makeText(applicationContext, currTime.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
