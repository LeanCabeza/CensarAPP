package com.example.censar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.censar.recyclerview.PersonaAdapter
import com.example.censar.R
import com.example.censar.model.Persona
import com.example.censar.viewModel.PersonaViewModel


class Listar_fragment : Fragment() {

    private lateinit var rv_Persona: RecyclerView
    private lateinit var arrayPersonas: ArrayList<Persona>
    private lateinit var personaAdapter: PersonaAdapter
    lateinit var persona_vm: PersonaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        persona_vm = ViewModelProvider(this).get(PersonaViewModel::class.java)
        rv_Persona= view.findViewById(R.id.listar_rv)
        rv_Persona.layoutManager = LinearLayoutManager(context)
        rv_Persona.setHasFixedSize(true)
        arrayPersonas = arrayListOf()
        personaAdapter = PersonaAdapter(arrayPersonas)
        rv_Persona.adapter = personaAdapter
        persona_vm.Listar(arrayPersonas,personaAdapter)
    }


}


