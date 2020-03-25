package com.example.introduccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        LoadData()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AlumnosAdapter(dataSet)
    }

    private fun LoadData() {
        for(x in 0..20) {
            dataSet.add(Alumno("16100${x.toString().padStart(3,'0')}","Estudiante ${x}","${if(x%2==0) "Ingeniería en Sistemas Computacionales" else "Ingeniería Industrial"}"))
        }
    }

    companion object {
        val dataSet = arrayListOf<Alumno>()
    }
}
