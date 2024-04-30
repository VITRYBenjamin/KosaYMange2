package com.example.kosaymange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeekAdapter(private val weekMealsList: ArrayList<Repas>) :
    RecyclerView.Adapter<WeekAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.week_rv_row,parent,false)
        println(itemView.findViewById(R.id.imageMealWeekDay))
        println(itemView.findViewById(R.id.textViewWeekDay))
        println(itemView.findViewById(R.id.TextViewMealWeekDay))
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val weekDayNames = listOf("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche")


        val currentItem = weekMealsList[position]
        holder.ivImageMealWeekDay.setImageResource(R.drawable.baseline_home_24)
        holder.tvTextViewWeekDay.text = weekDayNames[position]
        holder.tvTextViewMealWeekDay.text = currentItem.repasName
    }

    override fun getItemCount(): Int {
        return weekMealsList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val ivImageMealWeekDay : ImageView = itemView.findViewById(R.id.imageMealWeekDay)
        val tvTextViewWeekDay : TextView = itemView.findViewById(R.id.textViewWeekDay)
        val tvTextViewMealWeekDay : TextView = itemView.findViewById(R.id.TextViewMealWeekDay)
    }
}