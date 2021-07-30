package com.example.censar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.censar.R
import com.example.censar.viewModel.PersonaViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore


class Alta_fragment : Fragment() {

    lateinit var persona_vm: PersonaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alta, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dni: TextInputEditText = view.findViewById(R.id.frgalta_et_dni)
        val nombre: TextInputEditText = view.findViewById(R.id.g_et_nombre)
        val apellido: TextInputEditText = view.findViewById(R.id.g_et_apellido)
        val fechaNacimiento: TextInputEditText = view.findViewById(R.id.g_fecha_nac)
        val direccion: TextInputEditText = view.findViewById(R.id.g_et_direccion)
        val telefono: TextInputEditText = view.findViewById(R.id.g_et_telefono)
        val ocupacion: TextInputEditText = view.findViewById(R.id.g_et_Ocupacion)
        val iem: TextInputEditText = view.findViewById(R.id.g_et_iem)
        val rg_sexo:RadioGroup = view.findViewById(R.id.rg_sexo)
        val alta: Button = view.findViewById(R.id.frgalta_btn_alta)
        persona_vm = ViewModelProvider(this).get(PersonaViewModel::class.java)

        alta.setOnClickListener(View.OnClickListener {
            var flagOk = true

            if ( dni.text.toString() == "")
            {
                dni.error = "Requerido"
                flagOk = false
            } else if ( nombre.text.toString() == ""){
                nombre.error = "Requerido"
                flagOk = false
            }else if ( apellido.text.toString() == "") {
                apellido.error = "Requerido"
                flagOk = false
            }else if ( fechaNacimiento.text.toString() == "") {
                fechaNacimiento.error = "Requerido"
                flagOk = false
            }else if ( iem.text.toString() == "") {
                iem.error = "Requerido"
                flagOk = false
            }

            if(flagOk==false) {
                Toast.makeText(context, "Completar los campos obligatorios.", Toast.LENGTH_LONG).show()
            }else{
                persona_vm.Alta(dni,nombre,apellido,fechaNacimiento, direccion, telefono, ocupacion, iem, rg_sexo)
                Snackbar.make(it,"Dado de alta con exito", Snackbar.LENGTH_LONG).show()
                persona_vm.limpiarCampos(dni,nombre,apellido,fechaNacimiento,direccion,telefono,ocupacion,iem)
            }
        })
    }

}