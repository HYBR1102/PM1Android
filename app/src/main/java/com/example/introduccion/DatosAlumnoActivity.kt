package com.example.introduccion

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_datos_alumno.*

class DatosAlumnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_alumno)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", View.OnClickListener {
                        MiMetodo()
                    }).show()
        }

        val control = intent.extras?.getString("control", "")
        val nombre = intent.extras?.getString("nombre", "")
        val carrera = intent.extras?.getString("carrera","")

        Toast.makeText(this, "${control} ${nombre}", Toast.LENGTH_LONG).show()
    }

    private fun MiMetodo() {
        Toast.makeText(this, "Se invocó a MiMetodo", Toast.LENGTH_LONG).show()
    }

}
