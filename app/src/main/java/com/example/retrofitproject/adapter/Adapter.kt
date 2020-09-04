package com.example.retrofitproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.R
import com.example.retrofitproject.model.HoroscopeModel
import com.squareup.picasso.Picasso

class Adapter(private val horoscopeList: ArrayList<HoroscopeModel>) :
    RecyclerView.Adapter<Adapter.MyModelViewHolder>() {
    class MyModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textName)
        val date: TextView = view.findViewById(R.id.date)
        val imageURL: ImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyModelViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return MyModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return horoscopeList.count()
    }

    override fun onBindViewHolder(holder: MyModelViewHolder, position: Int) {
        val horescopes = horoscopeList[position]
        holder.name.text = horescopes.name
        holder.date.text = horescopes.date
        Picasso.get().load(horescopes.imageURL).into(holder.imageURL)
    }

}