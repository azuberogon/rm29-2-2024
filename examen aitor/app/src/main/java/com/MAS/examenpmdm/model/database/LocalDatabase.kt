package com.MAS.examenpmdm.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.MAS.examenpmdm.model.dao.UsuarioDAO
import com.MAS.examenpmdm.model.entity.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun userDao(): UsuarioDAO

    companion object{
        private const val DATABASE_NAME = "PMDM.db"

        @Volatile
        private var INSTANCE : LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    // Abrir conexión
                    instance = Room.databaseBuilder(context.applicationContext, LocalDatabase::class.java, DATABASE_NAME).build()
                    INSTANCE = instance
                }

                return instance
            }
        }

    }

}