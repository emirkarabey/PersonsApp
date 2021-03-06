package com.example.personsapp.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.personsapp.viewmodel.HomePageViewModel
import com.example.personsapp.viewmodel.PersonRegistrationPageViewModel

class PersonRegistrationPageViewModelFactory(var application: Application) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonRegistrationPageViewModel(application) as T
    }
}