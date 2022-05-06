package com.example.personsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.personsapp.repo.PersonDaoRepository

class PersonDetailPageViewModel : ViewModel(){
    var krepo = PersonDaoRepository()
    fun update(person_id:Int,person_name:String,person_phone:String){
        krepo.updatePerson(person_id,person_name,person_phone)
    }
}