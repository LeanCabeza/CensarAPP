package com.example.censar.recyclerview

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.censar.R
import com.example.censar.model.Persona
import com.example.censar.view.GestionPersona
import com.google.android.material.button.MaterialButton
import java.lang.Exception


class PersonaAdapter(val lista: ArrayList<Persona>) : RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.persona_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.dni.text = lista[position].dni
        holder.nombre.text = lista[position].nombre
        holder.apellido.text = lista[position].apellido
        holder.fecha_nacimiento.text = lista[position].fechaNacimiento
        holder.sexo.text = lista[position].sexo
        holder.direccion.text = lista[position].direccion
        holder.telefono.text = lista[position].telefono
        holder.ocupacion.text = lista[position].ocupacion
        holder.iem.text = lista[position].iem.toString()

        holder.editar.setOnClickListener(
            View.OnClickListener {
                try {
                    val intent: Intent = Intent(it.context,GestionPersona::class.java)
                    intent.putExtra("dni", lista[position].dni)
                    intent.putExtra("nombre", lista[position].nombre)
                    intent.putExtra("apellido", lista[position].apellido)
                    intent.putExtra("fecha_nacimiento", lista[position].fechaNacimiento)
                    intent.putExtra("sexo", lista[position].sexo)
                    intent.putExtra("direccion", lista[position].direccion)
                    intent.putExtra("telefono", lista[position].telefono)
                    intent.putExtra("ocupacion", lista[position].ocupacion)
                    intent.putExtra("iem", lista[position].iem.toString())
                    it.context.startActivity(intent)
                } catch (e: Exception) {
                    Log.e("Error->", e.message.toString())
                }
            }
        )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dni: TextView
        var nombre: TextView
        var apellido: TextView
        var fecha_nacimiento: TextView
        var sexo: TextView
        var direccion: TextView
        var telefono : TextView
        var ocupacion : TextView
        var iem : TextView
        var editar: MaterialButton

        init {
            dni = view.findViewById(R.id.persona_dni)
            nombre = view.findViewById(R.id.persona_nombre)
            apellido = view.findViewById(R.id.persona_apellido)
            fecha_nacimiento = view.findViewById(R.id.persona_fecha_nac)
            sexo = view.findViewById(R.id.persona_sexo)
            direccion = view.findViewById(R.id.persona_direccion)
            telefono = view.findViewById(R.id.persona_telefono)
            ocupacion = view.findViewById(R.id.persona_ocupacion)
            iem = view.findViewById(R.id.persona_iem)
            editar = view.findViewById(R.id.g_btn_modificar)

        }
    }

}