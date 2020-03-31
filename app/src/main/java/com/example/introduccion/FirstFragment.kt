package com.example.introduccion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("dato", "El dato desde el Fragment 1")
//
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
//        }

        val elementos = arrayOf("ISC", "INDUSTRIAL", "ELECTRÓNICA", "GESTIÓN")

//        val adaptador = ArrayAdapter(context, android.R.layout.simple_spinner_item, elementos)
        val adaptador = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, elementos)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCarrera.adapter = adaptador

        btnAgregar.setOnClickListener {
            val alumno = Alumno("${etControl.text}","${etNombre.text}", "${spinnerCarrera.selectedItem}")
            Singleton.dataSet.add(alumno)

            Snackbar.make(view, "¡Alumno agregado!", Snackbar.LENGTH_LONG).show()
        }

    }
}
