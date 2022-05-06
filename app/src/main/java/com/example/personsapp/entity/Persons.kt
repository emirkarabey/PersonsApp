package com.example.personsapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

/*
@Entity(tableName = "kisiler")
data class Persons(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "kisi_id") @NotNull var person_id:Int,
                   @ColumnInfo(name = "kisi_ad") @NotNull var person_name:String,
                   @ColumnInfo(name = "kisi_tel") @NotNull var person_phone:String) {
}
*/
data class Persons(@SerializedName("kisi_id")
                   @Expose
                   var person_id:Int,
                   @SerializedName("kisi_ad")
                   @Expose
                   var person_name:String,
                   @SerializedName("kisi_tel")
                   @Expose
                   var person_phone:String) {
}