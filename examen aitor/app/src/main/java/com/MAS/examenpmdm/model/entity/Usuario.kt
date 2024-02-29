package com.MAS.examenpmdm.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(

    @PrimaryKey(autoGenerate = true)
        val id: Int,
        var nombre:String,
        var edad:Int,
        var profesion:String,

    ){
    init {
        val sarna: Usuario? = Usuario(1,"Jose antonio",20,"coj")
        var userlist:MutableList<Usuario> = mutableListOf()
        if (sarna != null) {
            userlist.add(sarna)
        }
    }

}



