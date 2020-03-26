package com.example.introduccion

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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

        holder.itemView.setOnClickListener {
            //Toast.makeText(holder.itemView.context, dataSet.get(position).nombre, Toast.LENGTH_LONG).show()
            val intent = Intent(holder.itemView.context, DatosAlumnoActivity:: class.java)
            intent.putExtra("control", dataSet.get(position).control)
            intent.putExtra("nombre", dataSet.get(position).nombre)
            intent.putExtra("carrera",dataSet.get(position).carrera)

            holder.itemView.context.startActivity(intent)
        }

        holder.tvControl.text = dataSet.get(position).control
        holder.tvNombre.text = dataSet.get(position).nombre
        holder.tvCarrera.text = dataSet.get(position).carrera
    }
}