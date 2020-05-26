package com.example.kshitij.covidcalculator.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kshitij.covidcalculator.R
import com.example.kshitij.covidcalculator.data.PersonHealthData

class HealthClassAdapter internal constructor(
    context: Context
): RecyclerView.Adapter<HealthClassAdapter.HealthClassViewHolder>(){
    private val inflater = LayoutInflater.from(context)
    private var healthList = emptyList<PersonHealthData>()

    inner class HealthClassViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val healthTemp = itemView.findViewById<TextView>(R.id.text_body_temp)
        val oxygenLevel= itemView.findViewById<TextView>(R.id.text_oxygen_level)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthClassViewHolder {

        val itemView = inflater.inflate(R.layout.recycler_view_health_single_item, parent, false)
        return HealthClassViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return healthList.size
    }

    override fun onBindViewHolder(holder: HealthClassViewHolder, position: Int) {
        val current = healthList[position]
        holder.healthTemp.text = current.bodyTemperature.toString()
        holder.oxygenLevel.text = current.oxygenLevel.toString()
    }

}