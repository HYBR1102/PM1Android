package com.example.introduccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity(), EliminarAlumnoDialogFragment.EliminarAlumnoDialogListener {

    val onLongItemClickListener: (Int) -> Unit = {position ->
//        Toast.makeText(this, "Eliminar a ${Singleton.dataSet.get(position).control}", Toast.LENGTH_LONG).show()
        DialogEliminarAlumno(position)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        LoadData()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AlumnosAdapter(onLongItemClickListener)
    }

    override fun onResume() {
        super.onResume()

        recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun LoadData() {
        for(x in 0..20) {
            Singleton.dataSet.add(Alumno("16100${x.toString().padStart(3,'0')}","Estudiante ${x}","${if(x%2==0) "Ingeniería en Sistemas Computacionales" else "Ingeniería Industrial"}"))
        }
    }

    private fun DialogEliminarAlumno(position: Int) {
        val dialog = EliminarAlumnoDialogFragment(position)
        dialog.show(supportFragmentManager, "NoticeDialogFragment")
    }

    override fun onDialogPositiveClick(position: Int) {
        val alumno = Singleton.dataSet.get(position)
        Singleton.dataSet.removeAt(position)
        //recyclerView.adapter?.notifyItemRemoved(position)
        recyclerView.adapter?.notifyDataSetChanged()

//        Snackbar.make(recyclerView, "Alumno eliminado ${alumno.control}", Snackbar.LENGTH_LONG)
//                .setAction("Deshacer") {
//                    Singleton.dataSet.add(position, alumno)
//                    recyclerView.adapter?.notifyItemInserted(position)
//                }.show()

        Snackbar.make(recyclerView, "Alumno eliminado ${alumno.control}", Snackbar.LENGTH_LONG)
                .setAction("Deshacer", {
                    Singleton.dataSet.add(position, alumno)
                    //recyclerView.adapter?.notifyItemInserted(position)
                    recyclerView.adapter?.notifyDataSetChanged()
                }).show()
    }

    override fun onDialogNegativeClick(position: Int) {
        Toast.makeText(this, "No se eliminó al alumno", Toast.LENGTH_SHORT).show()
    }
}
