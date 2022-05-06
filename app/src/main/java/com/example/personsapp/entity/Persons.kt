package com.example.personsapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "kisiler")
data class Persons(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "kisi_id") @NotNull var person_id:Int,
                   @ColumnInfo(name = "kisi_ad") @NotNull var person_name:String,
                   @ColumnInfo(name = "kisi_tel") @NotNull var person_phone:String) {
}