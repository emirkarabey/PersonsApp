package com.example.personsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.personsapp.repo.PersonDaoRepository

class PersonRegistrationPageViewModel(application: Application) : AndroidViewModel(application){
    var krepo = PersonDaoRepository(application)
    fun registration(person_name:String,person_phone:String){
        krepo.registrationPerson(person_name, person_phone)
    }
}