package com.example.personsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.personsapp.repo.PersonDaoRepository

class PersonDetailPageViewModel(application: Application) : AndroidViewModel(application){
    var krepo = PersonDaoRepository(application)
    fun update(person_id:Int,person_name:String,person_phone:String){
        krepo.updatePerson(person_id,person_name,person_phone)
    }
}