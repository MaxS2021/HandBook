package com.example.handbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handbook.databinding.PlantItemBinding

class PlantAdapter(val listener: Listener): RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    val plantList =ArrayList<Plant>()
    class PlantHolder(item: View): RecyclerView.ViewHolder (item) {
        val bind = PlantItemBinding.bind(item)
        fun bind(plant: Plant, listener: Listener) {
            bind.im.setImageResource(plant.imageId)
            bind.twTitle.text = plant.title
            itemView.setOnClickListener{
                listener.onClick(plant)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position], listener)
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }

    // Слушатель нажатий в RecyclerView | Kotlin + Android Studio https://www.youtube.com/watch?v=13K72xJaAGc
    interface Listener{
        fun onClick(plant: Plant)
    }

}