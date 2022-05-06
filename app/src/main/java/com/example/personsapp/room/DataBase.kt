package com.example.personsapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.personsapp.entity.Persons

/*
@Database(entities = [Persons::class],version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun personsDao():PersonsDao

    companion object{
        var INSTANCE:DataBase? = null

        fun veritabaniErisim(context: Context):DataBase?{
            if (INSTANCE == null){

                synchronized(DataBase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "rehber.sqlite").createFromAsset("rehber.sqlite").build()
                }
            }
            return INSTANCE
        }
    }


}*/

