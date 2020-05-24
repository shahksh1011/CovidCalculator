package com.example.kshitij.covidcalculator.ui

import android.app.Activity
import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.kshitij.covidcalculator.R

class NewPersonActivity : AppCompatActivity() {

    private lateinit var firstNameEdit: EditText
    private lateinit var lastNameEdit: EditText
    private lateinit var ageEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_person)

        firstNameEdit = findViewById(R.id.edit_first_name)
        lastNameEdit = findViewById(R.id.edit_last_name)
        ageEdit = findViewById(R.id.edit_age)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(firstNameEdit.text) || TextUtils.isEmpty(lastNameEdit.text) || TextUtils.isEmpty(ageEdit.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }else{
                val firstName = firstNameEdit.text
                val lastName = lastNameEdit.text
                val age = ageEdit.text
                val bundle: Bundle = Bundle()
                bundle.putString("firstName", firstName.toString())
                bundle.putString("lastName", lastName.toString())
                bundle.putString("age", age.toString())
                replyIntent.putExtra(EXTRA_REPLY, bundle)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    companion object {
        const val EXTRA_REPLY = "com.example.kshitij.covidcalculator.ui.REPLY"
    }
}
