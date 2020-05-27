package com.example.kshitij.covidcalculator.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kshitij.covidcalculator.R
import com.example.kshitij.covidcalculator.data.Person
import java.util.*

class NewHealthRecord : AppCompatActivity() {

    private lateinit var bodyTemp: EditText
    private lateinit var oxygenLevel: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_health_record)
        val bundle = intent.getBundleExtra("Person")
        val person: Person = bundle.getSerializable("personData") as Person
        val submitButton  = findViewById<Button>(R.id.button_submit)
        bodyTemp = findViewById<EditText>(R.id.editText_bodyTemp)
        oxygenLevel = findViewById(R.id.editText_oxygenLevel)
        submitButton.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(bodyTemp.text) || TextUtils.isEmpty(oxygenLevel.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }else{
                val temp = bodyTemp.text
                val oxy = oxygenLevel.text
                val bundle = Bundle()
                bundle.putString("bodyTemp", temp.toString())
                bundle.putString("oxygenLevel", oxy.toString())
                bundle.putString("personId", person.id.toString())
                replyIntent.putExtra(EXTRA_REPLY, bundle)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    companion object{
        const val EXTRA_REPLY = "com.example.kshitij.covidcalculator.ui.health.REPLY"
    }
}
