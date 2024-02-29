package com.MAS.examenpmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.MAS.examenpmdm.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // Completar las variables y atributos necesarios como el recyclerview y la database...


        // Obtener todos los usuarios desde el DAO en una tarea en segundo plano
        GlobalScope.launch (Dispatchers.IO) {


            withContext(Dispatchers.Main) {
                // TODO
                // Configurar el RecyclerView con los usuarios obtenidos
            }
        }

    }
}