package com.example.personsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.personsapp.entity.Persons
import com.example.personsapp.repo.PersonDaoRepository

class HomePageViewModel(application: Application) :AndroidViewModel(application){
    var krepo = PersonDaoRepository(application)
    var personList = MutableLiveData<List<Persons>>()

    init {
        loadPersons()
        personList = krepo.getPerson()
    }

    fun loadPersons(){
        krepo.getAllPersons()
    }

    fun search(searchWord:String){
        krepo.searchPerson(searchWord)
    }

    fun delete(person_id:Int){
        krepo.deletePerson(person_id)
    }
}