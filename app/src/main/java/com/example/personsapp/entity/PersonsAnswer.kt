package com.example.personsapp.entity

import com.example.personsapp.entity.Persons
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonsAnswer(@SerializedName("kisiler")
                        @Expose
                        var persons:List<Persons>,
                         @SerializedName("success")
                        @Expose
                        var success:Int) {
}