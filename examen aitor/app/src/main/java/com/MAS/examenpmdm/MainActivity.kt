package com.MAS.examenpmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.MAS.examenpmdm.activities.FormActivity
import com.MAS.examenpmdm.activities.ListViewActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnFormulario : EditText
    private lateinit var btnLista : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLista= findViewById(R.id.btnLista)
        btnFormulario= findViewById(R.id.btnFormulario)


        btnFormulario.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)

        }

        btnLista.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)

        }

    }

    fun goToFormulario(view: View) { // Este método navegará al FormActivity


    }

    fun goToListView(view: View) { // Este método navegará al ListViewActivity
        // TODO
    }
}