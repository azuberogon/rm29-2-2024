package com.MAS.examenpmdm.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.MAS.examenpmdm.model.entity.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM Usuario")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Usuario>

    @Insert
    fun insertAll(vararg users: Usuario)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: Usuario)

    @Query("DELETE FROM Usuario")
    suspend fun deleteAll()

    @Query("DELETE FROM Usuario WHERE id = :user")
    suspend fun delete(user: String)


}