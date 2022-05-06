package com.example.personsapp.room

import androidx.room.*
import com.example.personsapp.entity.Persons

/*
@Dao
interface PersonsDao {
    @Query("SELECT * FROM kisiler")
    suspend fun allPersons():List<Persons>

    @Insert
    suspend fun addPerson(kisiler: Persons)

    @Update
    suspend fun updatePerson(kisiler: Persons)

    @Delete
    suspend fun deletePerson(kisiler: Persons)

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :searchWord || '%'")
    suspend fun searchPerson(searchWord:String):List<Persons>

}*/