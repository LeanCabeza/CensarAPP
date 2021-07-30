package com.example.censar.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.censar.R
import com.example.censar.viewModel.PersonaViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore

class GestionPersona : AppCompatActivity() {

    lateinit var dni: TextView
    lateinit var nombre: TextInputEditText
    lateinit var apellido: TextInputEditText
    lateinit var fechaNacimiento: TextInputEditText
    lateinit var sexo: TextInputEditText
    lateinit var direccion: TextInputEditText
    lateinit var telefono: TextInputEditText
    lateinit var ocupacion: TextInputEditText
    lateinit var iem: TextInputEditText
    lateinit var modificar: MaterialButton
    lateinit var borrar: MaterialButton
    lateinit var persona_vm: PersonaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_persona)
        persona_vm = ViewModelProvider(this).get(PersonaViewModel::class.java)
        inicializar()
        mapperElements()
        guardarPersonaModificada()
        borrarPersona()
    }


    private fun guardarPersonaModificada() {

        modificar.setOnClickListener(
            View.OnClickListener {
                MaterialAlertDialogBuilder(this)
                    .setIcon(R.drawable.ic_no)
                    .setTitle(resources.getString(R.string.title_mod))
                    .setMessage(resources.getString(R.string.supporting_text_mod))
                    .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
                        Snackbar.make(it,"Operacion cancelada", Snackbar.LENGTH_LONG).show()
                    }
                    .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                        //Update por DNI
                        persona_vm.update(dni,nombre,apellido,fechaNacimiento, sexo, direccion, telefono, ocupacion, iem)

                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    .show()
            }
        )
    }

    private fun borrarPersona() {
        borrar.setOnClickListener(
            View.OnClickListener {
                MaterialAlertDialogBuilder(this)
                    .setIcon(R.drawable.ic_no)
                    .setTitle(resources.getString(R.string.title))
                    .setMessage(resources.getString(R.string.supporting_text))
                    .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
                        Snackbar.make(it,"Operacion cancelada", Snackbar.LENGTH_LONG).show()
                    }
                    .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                        //BORRAR POR DNI
                        persona_vm.delete(dni)

                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    .show()
            }
        )
    }

    private fun mapperElements() {
        dni.text = intent.getStringExtra("dni")
        nombre.setText(intent.getStringExtra("nombre"))
        apellido.setText(intent.getStringExtra("apellido"))
        fechaNacimiento.setText(intent.getStringExtra("fecha_nacimiento"))
        sexo.setText(intent.getStringExtra("sexo"))
        direccion.setText(intent.getStringExtra("direccion"))
        telefono.setText(intent.getStringExtra("telefono"))
        ocupacion.setText(intent.getStringExtra("ocupacion"))
        iem.setText(intent.getStringExtra("iem"))

    }

    private fun inicializar() {
        dni = findViewById(R.id.g_tv_dni)
        nombre = findViewById(R.id.g_et_nombre)
        apellido = findViewById(R.id.g_et_apellido)
        fechaNacimiento = findViewById(R.id.g_fecha_nac)
        sexo = findViewById(R.id.g_et_sexo)
        direccion = findViewById(R.id.g_et_direccion)
        telefono = findViewById(R.id.g_et_telefono)
        ocupacion = findViewById(R.id.g_et_Ocupacion)
        iem = findViewById(R.id.g_et_iem)
        modificar = findViewById(R.id.g_btn_modificar)
        borrar = findViewById(R.id.g_btn_baja)

    }

}