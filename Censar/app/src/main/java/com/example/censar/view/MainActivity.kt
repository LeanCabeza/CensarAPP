package com.example.censar.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.censar.R
import com.example.censar.fragments.Alta_fragment
import com.example.censar.fragments.Listar_fragment

class MainActivity : AppCompatActivity() {

    lateinit var alta: ImageButton
    lateinit var listar: ImageButton
    lateinit var informes: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializar()

        // SECCION FRAGMENTS

        val alta_frg = Alta_fragment()
        val listar_frg = Listar_fragment()
        val manager = supportFragmentManager


        alta.setOnClickListener(View.OnClickListener {

            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frg_container,alta_frg)
            transaction.commit()

        })

        listar.setOnClickListener(View.OnClickListener {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frg_container,listar_frg)
            transaction.commit()

        })

        informes.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Informes::class.java)
            startActivity(intent)
        })
    }

    private fun inicializar() {
        alta = findViewById(R.id.btn_alta)
        listar = findViewById(R.id.btn_listar)
        informes = findViewById(R.id.btn_informes)

    }

}