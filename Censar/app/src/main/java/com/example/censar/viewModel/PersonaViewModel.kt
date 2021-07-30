package com.example.censar.viewModel
import android.os.Handler
import android.util.Log
import android.widget.*
import androidx.lifecycle.ViewModel
import com.example.censar.R
import com.example.censar.recyclerview.InformeAdapter
import com.example.censar.recyclerview.PersonaAdapter
import com.example.censar.model.Persona
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.*
import com.google.firebase.firestore.EventListener
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

class PersonaViewModel: ViewModel() {


    fun Alta(dni:EditText,
             nombre:EditText,
             apellido:EditText,
             fechaNacimiento:EditText,
             direccion:EditText,
             telefono:EditText,
             ocupacion:EditText,
             iem:EditText,
             rg_sexo:RadioGroup){

            val db:FirebaseFirestore
            db = FirebaseFirestore.getInstance()
            db.collection("Persona").document(dni.text.toString()).set(
                hashMapOf(
                    "dni" to dni.text.toString(),
                    "nombre" to nombre.text.toString(),
                    "apellido" to apellido.text.toString(),
                    "fechaNacimiento" to fechaNacimiento.text.toString(),
                    "sexo" to obtenerSexo(rg_sexo),
                    "direccion" to direccion.text.toString(),
                    "telefono" to telefono.text.toString(),
                    "ocupacion" to ocupacion.text.toString(),
                    "iem" to iem.text.toString().toInt()
                )
            )

    }

    fun Listar(arrayPersonas:ArrayList<Persona>,
               personaAdapter: PersonaAdapter)
    {
        val db:FirebaseFirestore
        db = FirebaseFirestore.getInstance()
        db.collection("Persona").
        addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {

                if(error!=null){
                    Log.e("Firestore Error",error.message.toString())
                    return
                }
                for(dc: DocumentChange in value?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED){
                        arrayPersonas.add(dc.document.toObject(Persona::class.java))
                    }
                }
                personaAdapter.notifyDataSetChanged()
            }
        })
    }

    fun update (dni:TextView,
                nombre:EditText,
                apellido:EditText,
                fechaNacimiento:EditText,
                sexo:EditText,
                direccion:EditText,
                telefono:EditText,
                ocupacion:EditText,
                iem:EditText
    ){
        val db:FirebaseFirestore
        db = FirebaseFirestore.getInstance()
        db.collection("Persona").document(dni.text.toString()).set(
            hashMapOf(
                "dni" to dni.text.toString(),
                "nombre" to nombre.text.toString(),
                "apellido" to apellido.text.toString(),
                "fechaNacimiento" to fechaNacimiento.text.toString(),
                "sexo" to sexo.text.toString(),
                "direccion" to direccion.text.toString(),
                "telefono" to telefono.text.toString(),
                "ocupacion" to ocupacion.text.toString(),
                "iem" to iem.text.toString().toInt()
            )
        )
    }

    fun delete(dni:TextView){
        val db:FirebaseFirestore
        db = FirebaseFirestore.getInstance()
        db.collection("Persona").document(dni.text.toString()).delete()
    }

    fun informeDesocupados(arrayPersonaInforme:ArrayList<Persona>,
                           hombres_value:TextView,
                           mujeres_value:TextView,
                           hombres_info:TextView,
                           mujeres_info:TextView,
                           informeAdapter: InformeAdapter
    ) {

        val mayorEdad = Calendar.getInstance().get(Calendar.YEAR) -18
        val db:FirebaseFirestore

        db = FirebaseFirestore.getInstance()
        db.collection("Persona")
            .whereEqualTo("ocupacion","Desocupado")
            .whereLessThan("fechaNacimiento", "${mayorEdad}/00/00")
            // **MAGIA OSCURA** , seguramente debe comparar el string 'date' por el codigo ASCII
            // personalmente preferiria que me ingresen la edad directamente por parametro , o un checkbox indicando si es mayor.
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if(error!=null){
                        Log.e("Firestore Error",error.message.toString())
                        return
                    }
                    for(dc: DocumentChange in value?.documentChanges!!){
                        if(dc.type == DocumentChange.Type.ADDED){
                            arrayPersonaInforme.add(dc.document.toObject(Persona::class.java))
                            hombres_value.setText(informeHombres(arrayPersonaInforme).toString())
                            mujeres_value.setText(informeMujeres(arrayPersonaInforme).toString())
                            hombres_info.setText("Hombres :")
                            mujeres_info.setText("Mujeres :")
                        }
                    }
                    informeAdapter.notifyDataSetChanged()
                }
            })
    }


    fun informePobreza(arrayPersonaInforme:ArrayList<Persona>,
                       hombres_value:TextView,
                       mujeres_value:TextView,
                       hombres_info:TextView,
                       mujeres_info:TextView,
                       informeAdapter: InformeAdapter
    ) {
        val db:FirebaseFirestore
        db = FirebaseFirestore.getInstance()
        db.collection("Persona").whereLessThan("iem", 5000)
            .addSnapshotListener(object : EventListener<QuerySnapshot> {

                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if(error!=null){
                        Log.e("Firestore Error",error.message.toString())
                        return
                    }
                    for(dc: DocumentChange in value?.documentChanges!!){
                        if(dc.type == DocumentChange.Type.ADDED){
                            arrayPersonaInforme.add(dc.document.toObject(Persona::class.java))

                            hombres_value.setText(informeHombres(arrayPersonaInforme).toString())
                            mujeres_value.setText(informeMujeres(arrayPersonaInforme).toString())
                            hombres_info.setText("Hombres :")
                            mujeres_info.setText("Mujeres :")
                        }
                    }
                    informeAdapter.notifyDataSetChanged()
                }
            })
    }


    fun informeApellidos(arrayPersonaInforme:ArrayList<Persona>,
                         hombres_value:TextView,
                         mujeres_value:TextView,
                         hombres_info:TextView,
                         mujeres_info:TextView,
                         informeAdapter: InformeAdapter
    ) {

        val db:FirebaseFirestore
        db = FirebaseFirestore.getInstance()
        db.collection("Persona").orderBy("apellido",Query.Direction.ASCENDING)
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if(error!=null){
                        Log.e("Firestore Error",error.message.toString())
                        return
                    }
                    for(dc: DocumentChange in value?.documentChanges!!){
                        if(dc.type == DocumentChange.Type.ADDED){
                            arrayPersonaInforme.add(dc.document.toObject(Persona::class.java))
                            hombres_value.setText(informeHombres(arrayPersonaInforme).toString())
                            mujeres_value.setText(informeMujeres(arrayPersonaInforme).toString())
                            hombres_info.setText("Hombres :")
                            mujeres_info.setText("Mujeres :")
                        }
                    }
                    informeAdapter.notifyDataSetChanged()
                }
            })
    }


    fun informeMujeres(array:List<Persona>): Int {
        var contador = 0

        for(auxPersona:Persona in array ){
            if(auxPersona.sexo.equals("Femenino")){
                contador++
            }
        }
        return contador
    }

    fun informeHombres(array:List<Persona>): Int {
        var contador = 0

        for(auxPersona:Persona in array ){
            if(auxPersona.sexo.equals("Masculino")){
                contador++
            }
        }
        return contador
    }

    fun limpiarCampos(dni: TextInputEditText, nombre: TextInputEditText, apellido: TextInputEditText, fechaNacimiento: TextInputEditText, direccion: TextInputEditText, telefono: TextInputEditText, ocupacion: TextInputEditText, iem: TextInputEditText
    ) {
        dni.setText("")
        nombre.setText("")
        apellido.setText("")
        fechaNacimiento.setText("")
        direccion.setText("")
        telefono.setText("")
        ocupacion.setText("")
        iem.setText("")

    }

    private fun obtenerSexo(rg_sexo:RadioGroup): String {
        if(rg_sexo.getCheckedRadioButtonId() == R.id.rb_masculino){
            return "Masculino"
        }else if(rg_sexo.getCheckedRadioButtonId() == R.id.rb_femenino){
            return "Femenino"
        }else{
            return "Otro"
        }
    }

}