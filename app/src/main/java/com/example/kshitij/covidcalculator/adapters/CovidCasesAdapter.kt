package com.example.kshitij.covidcalculator.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kshitij.covidcalculator.R
import com.example.kshitij.covidcalculator.data.response.Data

class CovidCasesAdapter internal constructor(
    context: Context,
    private val caseList: List<Data>
): RecyclerView.Adapter<CovidCasesAdapter.CovidCasesViewHolder>(){
    private val inflater = LayoutInflater.from(context)

    inner class CovidCasesViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val stateName = itemView.findViewById<TextView>(R.id.text_state)
        val recDate = itemView.findViewById<TextView>(R.id.text_record_date)
        val recoveredCases = itemView.findViewById<TextView>(R.id.text_total_recovered)
        val totalCases = itemView.findViewById<TextView>(R.id.text_total)
        val totalDeaths = itemView.findViewById<TextView>(R.id.text_total_deaths)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidCasesViewHolder {
        val itemView = inflater.inflate(R.layout.single_covid_update_item, parent, false)
        return CovidCasesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return caseList.size
    }

    override fun onBindViewHolder(holder: CovidCasesViewHolder, position: Int) {
        val current = caseList[position]
        holder.stateName.text = "Country Code: " + current.countrycode
        holder.recDate.text = "Date: " + current.date

        holder.recoveredCases.text ="Recovered Cases: " + current.recovered
        holder.totalCases.text = "Total Cases: "+ current.cases
        holder.totalDeaths.text = "Total Dealths: " + current.deaths


    }

}