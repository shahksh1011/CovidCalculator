package com.example.kshitij.covidcalculator.adapters

import com.example.kshitij.covidcalculator.data.Person
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kshitij.covidcalculator.R
import kotlinx.android.synthetic.main.recycler_view_person.view.*

class PersonClassAdaper internal constructor(
    context: Context
): RecyclerView.Adapter<PersonClassAdaper.PersonViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var listOfPerson = emptyList<Person>()

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personItemView: TextView = itemView.findViewById(R.id.person_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val itemView = inflater.inflate(R.layout.recycler_view_person, parent, false)
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val current: Person = listOfPerson[position]
        holder.personItemView.text = current.firstName + " " + current.lastName

    }

    internal fun setPeople(listOfPerson: List<Person>){
        this.listOfPerson = listOfPerson
        notifyDataSetChanged()
    }

    override fun getItemCount()= listOfPerson.size


}