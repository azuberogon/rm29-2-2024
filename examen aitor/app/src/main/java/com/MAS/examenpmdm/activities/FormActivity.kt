package com.MAS.examenpmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.MAS.examenpmdm.R
import com.MAS.examenpmdm.model.database.LocalDatabase
import com.MAS.examenpmdm.model.entity.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import com.MAS.examenpmdm.model.dao.UsuarioDAO

class FormActivity : AppCompatActivity() {

    private lateinit var editTextNombre : EditText
    private lateinit var editTextedad : EditText
    private lateinit var editTextprofesion : EditText
    private lateinit var btnVolver : EditText //form_btn_volver
    private lateinit var btnGuardar : EditText //    form_btn_guardar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        editTextNombre = findViewById(R.id.form_et_nombre)
        editTextedad = findViewById(R.id.form_et_edad)
        editTextprofesion = findViewById(R.id.form_et_profesion)

        btnGuardar = findViewById(R.id.form_btn_guardar)
        btnVolver = findViewById(R.id.form_btn_volver)



    }


    fun goToMain(view: View) { // Método que vuelve a la pantalla principal
        finish()
    }

    fun guardar(view: View) { // Está incompleto, deberá
        val usuario = Usuario(0,editTextNombre.text.toString(),editTextedad.text.toString().toInt(),editTextprofesion.text.toString())
        val localdb = LocalDatabase.getInstance(this)

        GlobalScope.launch(Dispatchers.IO) {
            localdb.userDao().insertAll(usuario)
        }
    }
}