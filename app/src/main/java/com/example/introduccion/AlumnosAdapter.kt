package com.example.introduccion

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.alumnos_recyclerview_item.view.*

class AlumnosAdapter(private val longItemClickistener: (Int) -> Unit) :
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

    override fun getItemCount() = Singleton.dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            //Toast.makeText(holder.itemView.context, dataSet.get(position).nombre, Toast.LENGTH_LONG).show()
            val intent = Intent(holder.itemView.context, DatosAlumnoActivity:: class.java)
            intent.putExtra("control", Singleton.dataSet.get(position).control)
            intent.putExtra("nombre", Singleton.dataSet.get(position).nombre)
            intent.putExtra("carrera",Singleton.dataSet.get(position).carrera)

            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            longItemClickistener.invoke(position)
            true
        }

        holder.tvControl.text = Singleton.dataSet.get(position).control
        holder.tvNombre.text = Singleton.dataSet.get(position).nombre
        holder.tvCarrera.text = Singleton.dataSet.get(position).carrera
    }
}