package com.example.censar

import android.app.Person
import com.example.censar.model.Persona
import com.example.censar.viewModel.PersonaViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PersonaVmUnitTest {

        val persona_vm:PersonaViewModel = Mockito.mock(PersonaViewModel::class.java)
        val hombre:Persona = Persona("1","Test","Test","2020/01/01","Masculino","Test","test","test",100)
        val mujer = Persona("2","Test","Test","2020/01/01","Femenino","Test","test","test",100)

    lateinit var arrayPersonas:ArrayList<Persona>


    @Before
    fun iniciliazarElementos(){
        arrayPersonas=ArrayList()
        Mockito.`when`(persona_vm.informeHombres(arrayPersonas)).thenReturn(1)
        Mockito.`when`(persona_vm.informeMujeres(arrayPersonas)).thenReturn(1)
    }

    @Test
    fun cantHombres() {
        arrayPersonas.add(hombre)
        assertEquals(persona_vm.informeHombres(arrayPersonas),1)
    }

    @Test
    fun cantMujeres() {
        arrayPersonas.add(mujer)
        assertEquals(persona_vm.informeHombres(arrayPersonas),1)
    }



}