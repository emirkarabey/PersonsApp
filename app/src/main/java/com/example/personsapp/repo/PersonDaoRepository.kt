package com.example.personsapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.personsapp.entity.Persons

class PersonDaoRepository {
    var personsList = MutableLiveData<List<Persons>>()

    init {
        personsList = MutableLiveData()
    }

    fun getPerson():MutableLiveData<List<Persons>>{
        return personsList
    }

    fun getAllPersons(){
        val list = mutableListOf<Persons>()
        val k1 = Persons(1,"Ahmet","111111")
        val k2 = Persons(2,"Zeynep","222222")
        list.add(k1)
        list.add(k2)
        personsList.value=list
    }

    fun searchPerson(searchWord:String){
        Log.e("Kisi arama",searchWord)
    }

    fun registrationPerson(person_name:String,person_phone:String){
        Log.e("Kisi kayıt","$person_name - $person_phone")
    }

    fun updatePerson(person_id:Int,person_name:String,person_phone:String){
        Log.e("Kisi Güncelle","$person_id - $person_name - $person_phone")
    }

    fun deletePerson(person_id:Int){
        Log.e("Kisi Sil","$person_id")
    }
}