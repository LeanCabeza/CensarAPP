package com.example.censar.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.censar.recyclerview.InformeAdapter
import com.example.censar.R
import com.example.censar.model.Persona
import com.example.censar.viewModel.PersonaViewModel

class Informes : AppCompatActivity() {


    lateinit var info_asc: Button
    lateinit var desocupados: Button
    lateinit var pobre: Button
    lateinit var hombres_value: TextView
    lateinit var mujeres_value: TextView
    lateinit var hombres_info: TextView
    lateinit var mujeres_info: TextView
    lateinit var persona_vm: PersonaViewModel


    private lateinit var rv_Informes: RecyclerView
    private lateinit var arrayPersonaInforme: ArrayList<Persona>
    private lateinit var informeAdapter: InformeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informes)
        inicializar()

        persona_vm = ViewModelProvider(this).get(PersonaViewModel::class.java)

        info_asc.setOnClickListener(View.OnClickListener {

            rv_Informes= findViewById(R.id.info_rv)
            rv_Informes.layoutManager = LinearLayoutManager(this)
            rv_Informes.setHasFixedSize(true)
            arrayPersonaInforme = arrayListOf()
            informeAdapter = InformeAdapter(arrayPersonaInforme)
            rv_Informes.adapter = informeAdapter
            persona_vm.informeApellidos(arrayPersonaInforme,hombres_value,mujeres_value,hombres_info,mujeres_info,informeAdapter)

        })

        desocupados.setOnClickListener(View.OnClickListener {

            rv_Informes= findViewById(R.id.info_rv)
            rv_Informes.layoutManager = LinearLayoutManager(this)
            rv_Informes.setHasFixedSize(true)
            arrayPersonaInforme = arrayListOf()
            informeAdapter = InformeAdapter(arrayPersonaInforme)
            rv_Informes.adapter = informeAdapter
            persona_vm.informeDesocupados(arrayPersonaInforme,hombres_value,mujeres_value,hombres_info,mujeres_info,informeAdapter)

        })

        pobre.setOnClickListener(View.OnClickListener {

            rv_Informes= findViewById(R.id.info_rv)
            rv_Informes.layoutManager = LinearLayoutManager(this)
            rv_Informes.setHasFixedSize(true)
            arrayPersonaInforme = arrayListOf()
            informeAdapter = InformeAdapter(arrayPersonaInforme)
            rv_Informes.adapter = informeAdapter
            persona_vm.informePobreza(arrayPersonaInforme,hombres_value,mujeres_value,hombres_info,mujeres_info,informeAdapter)

        })

    }


    private fun inicializar() {
        info_asc = findViewById(R.id.info_btn_asc)
        desocupados = findViewById(R.id.info_btn_desocupado)
        pobre = findViewById(R.id.info_btn_pobresa)
        hombres_value = findViewById(R.id.info_tv_masculino)
        mujeres_value = findViewById(R.id.info_tv_femenino)
        hombres_info = findViewById(R.id.info_tv_1)
        mujeres_info = findViewById(R.id.info_tv_2)
    }
}