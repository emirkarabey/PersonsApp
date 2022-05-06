package com.example.personsapp.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.personsapp.entity.CRUDAnswer
import com.example.personsapp.entity.Persons
import com.example.personsapp.entity.PersonsAnswer
import com.example.personsapp.retrofit.ApiUtils
import com.example.personsapp.retrofit.PersonsDaoInterface
//import com.example.personsapp.room.DataBase
import retrofit2.Call
import retrofit2.Response

class PersonDaoRepository(var application: Application) {
    var personsList = MutableLiveData<List<Persons>>()
    //var db:DataBase
    var personDaoInterface:PersonsDaoInterface

    init {
        personDaoInterface = ApiUtils.getPersonDaoInterface()
        //db= DataBase.veritabaniErisim(application!!)!!
        personsList = MutableLiveData()
    }

    fun getPerson():MutableLiveData<List<Persons>>{
        return personsList
    }

    fun getAllPersons(){
        personDaoInterface.allPersons().enqueue(object : retrofit2.Callback<PersonsAnswer> {
            override fun onResponse(
                call: Call<PersonsAnswer>,response: Response<PersonsAnswer>) {
                val list = response.body().persons
                personsList.value = list
            }
            override fun onFailure(call: Call<PersonsAnswer>?, t: Throwable?) {}
        })
        /*
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            //personsList.value = db.personsDao().allPersons()
        }

         */
    }

    fun searchPerson(searchWord:String){
        personDaoInterface.searchPerson(searchWord).enqueue(object : retrofit2.Callback<PersonsAnswer> {
            override fun onResponse(
                call: Call<PersonsAnswer>,response: Response<PersonsAnswer>) {
                val list = response.body().persons
                personsList.value = list
            }
            override fun onFailure(call: Call<PersonsAnswer>?, t: Throwable?) {}
        })
        /*
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            //personsList.value = db.personsDao().searchPerson(searchWord)
        }

         */
    }

    fun registrationPerson(person_name:String,person_phone:String){
        personDaoInterface.addPerson(person_name,person_phone).enqueue(object : retrofit2.Callback<CRUDAnswer>{
            override fun onResponse(call: Call<CRUDAnswer>, response: Response<CRUDAnswer>) {}
            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {}
        })

        /*
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson = Persons(0,person_name,person_phone)
            //db.personsDao().addPerson(newPerson)
        }

         */
    }

    fun updatePerson(person_id:Int,person_name:String,person_phone:String){
        personDaoInterface.updatePerson(person_id,person_name,person_phone).enqueue(object : retrofit2.Callback<CRUDAnswer>{
            override fun onResponse(call: Call<CRUDAnswer>, response: Response<CRUDAnswer>) {}
            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {}
        })
        /*
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val person = Persons(person_id,person_name,person_phone)
            //db.personsDao().updatePerson(person)
        }

         */
    }

    fun deletePerson(person_id:Int){
        personDaoInterface.deletePerson(person_id).enqueue(object : retrofit2.Callback<CRUDAnswer>{
            override fun onResponse(call: Call<CRUDAnswer>, response: Response<CRUDAnswer>) {
                getAllPersons()
            }
            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {}
        })
        /*
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val person = Persons(person_id,"","")
            //db.personsDao().deletePerson(person)
            getAllPersons()
        }

         */
    }
}