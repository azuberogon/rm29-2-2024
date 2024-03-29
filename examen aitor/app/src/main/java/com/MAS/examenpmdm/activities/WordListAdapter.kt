/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample

import android.app.Application
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.provider.UserDictionary.Words
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.MAS.examenpmdm.model.entity.Usuario
import com.example.android.roomwordssample.WordListAdapter.WordViewHolder
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WordListAdapter() : ListAdapter<Usuario, WordViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nombre, current.edad, current.genero)
        holder.itemView.setOnClickListener {
            //Log.d(ContentValues.TAG, "Se ha pulsado en el item que tiene:");
            //Log.d(ContentValues.TAG, "Título: " + current.word);
            //Log.d(ContentValues.TAG, "Género: " + current.genero);
            //Log.d(ContentValues.TAG, "Autor: " + current.autor);
            val intent = Intent(it.context, BookDetailsActivity::class.java)
            intent.putExtra("titulo",current.word)
            intent.putExtra("genero",current.genero)
            intent.putExtra("autor",current.autor)
            it.context.startActivity(intent)

        }
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tituloItemView: TextView = itemView.findViewById(R.id.textViewTitulo)
        private val genItemView: TextView = itemView.findViewById(R.id.textViewGenero)
        private val autorItemView: TextView = itemView.findViewById(R.id.textViewAutor)

        fun bind(textTitulo: String, textGen: String?, textAutor: String?) {
            tituloItemView.text = textTitulo
            genItemView.text = textGen
            autorItemView.text = textAutor
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.word == newItem.word
            }
        }
    }
}
