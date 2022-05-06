package com.example.personsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.personsapp.repo.PersonDaoRepository

class PersonRegistrationPageViewModel : ViewModel(){
    var krepo = PersonDaoRepository()
    fun registration(person_name:String,person_phone:String){
        krepo.registrationPerson(person_name, person_phone)
    }
}