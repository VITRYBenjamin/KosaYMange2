package com.example.kosaymange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RepasAdapter(private val repasList: ArrayList<Repas>) :
    RecyclerView.Adapter<RepasAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row,parent,false)

        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return repasList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = repasList[position]
        holder.tvRepasName.text = currentItem.repasName
        holder.ivRepasImage.setImageResource(R.drawable.baseline_home_24)

    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val tvRepasName : TextView = itemView.findViewById(R.id.textRepas)
        val ivRepasImage : ImageView = itemView.findViewById(R.id.imageRepas)

    }
}