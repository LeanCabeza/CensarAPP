package com.example.censar.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.censar.R
import com.example.censar.model.Persona

class InformeAdapter(val lista: ArrayList<Persona>) : RecyclerView.Adapter<InformeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.informe_layout, parent, false)
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

        init {
            dni = view.findViewById(R.id.i_tv_dni)
            nombre = view.findViewById(R.id.i_tv_nombre)
            apellido = view.findViewById(R.id.i_tv_apellido)
            fecha_nacimiento = view.findViewById(R.id.i_tv_fechaNacimiento)
            sexo = view.findViewById(R.id.i_tv_sexo)
            direccion = view.findViewById(R.id.i_tv_direccion)
            telefono = view.findViewById(R.id.i_tv_telefono)
            ocupacion = view.findViewById(R.id.i_tv_ocupacion)
            iem = view.findViewById(R.id.i_tv_iem)
        }
    }


}