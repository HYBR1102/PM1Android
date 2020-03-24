package com.example.introduccion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.alumnos_recyclerview_item.view.*

class AlumnosAdapter(private val dataSet: List<Alumno>) :
        RecyclerView.Adapter<AlumnosAdapter.ViewHolder>(){

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvControl = v.tvControl
        val tvNombre = v.tvNombre
        val tvCarrera = v.tvCarrera
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.alumnos_recyclerview_item, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvControl.text = dataSet.get(position).control
        holder.tvNombre.text = dataSet.get(position).nombre
        holder.tvCarrera.text = dataSet.get(position).carrera
    }
}