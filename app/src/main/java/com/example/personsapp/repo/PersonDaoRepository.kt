package com.example.personsapp.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.personsapp.entity.Persons
import com.example.personsapp.room.DataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PersonDaoRepository(var application: Application) {
    var personsList = MutableLiveData<List<Persons>>()
    var db:DataBase

    init {
        db= DataBase.veritabaniErisim(application!!)!!
        personsList = MutableLiveData()
    }

    fun getPerson():MutableLiveData<List<Persons>>{
        return personsList
    }

    fun getAllPersons(){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = db.personsDao().allPersons()
        }
    }

    fun searchPerson(searchWord:String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = db.personsDao().searchPerson(searchWord)
        }
    }

    fun registrationPerson(person_name:String,person_phone:String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson = Persons(0,person_name,person_phone)
            db.personsDao().addPerson(newPerson)
        }
    }

    fun updatePerson(person_id:Int,person_name:String,person_phone:String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val person = Persons(person_id,person_name,person_phone)
            db.personsDao().updatePerson(person)
        }
    }

    fun deletePerson(person_id:Int){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val person = Persons(person_id,"","")
            db.personsDao().deletePerson(person)
            getAllPersons()
        }
    }
}