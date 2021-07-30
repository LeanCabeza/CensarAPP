package com.example.censar.model
import java.io.Serializable

data class Persona(
    val dni: String?= null
    , val nombre: String?= null
    , val apellido: String?= null
    , val fechaNacimiento:String?= null
    , val sexo:String?= null
    , val direccion:String?= null
    , val telefono:String?= null
    , val ocupacion:String?= null
    , val iem:Int?= null)
    : Serializable