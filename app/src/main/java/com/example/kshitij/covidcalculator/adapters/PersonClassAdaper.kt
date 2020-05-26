package com.example.kshitij.covidcalculator.adapters

import com.example.kshitij.covidcalculator.data.Person
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kshitij.covidcalculator.R
import kotlin.reflect.KFunction1

class PersonClassAdaper internal constructor(
    context: Context,
    val itemClickListener: PersonClassAdaper.itemcClickListener
): RecyclerView.Adapter<PersonClassAdaper.PersonViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var listOfPerson = emptyList<Person>()

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personItemView: TextView = itemView.findViewById(R.id.person_name)
        val personCard: CardView = itemView.findViewById(R.id.person_linear_layout)

        val personAge: TextView = itemView.findViewById(R.id.person_age)

        fun bind(person: Person, clickListener: PersonClassAdaper.itemcClickListener){
            personAge.text = person.age
            personItemView.text = person.firstName + " " + person.lastName
            itemView.setOnClickListener {
                clickListener.onItemClicked(person)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val itemView = inflater.inflate(R.layout.recycler_view_person, parent, false)


        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val current: Person = listOfPerson[position]
        holder.bind(current, itemClickListener)

    }

    interface itemcClickListener{
        fun onItemClicked(person: Person)
    }


    internal fun setPeople(listOfPerson: List<Person>){
        this.listOfPerson = listOfPerson
        notifyDataSetChanged()
    }

    override fun getItemCount()= listOfPerson.size


}