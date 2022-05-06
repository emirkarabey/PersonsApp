package com.example.personsapp

import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personsapp.viewmodel.HomePageViewModel
import com.example.personsapp.viewmodel.PersonRegistrationPageViewModel
import com.example.personsapp.viewmodelfactory.HomePageViewModelFactory
import com.example.personsapp.viewmodelfactory.PersonRegistrationPageViewModelFactory

@Composable
fun PersonRegistrationPage() {
    val tfPersonName = remember{ mutableStateOf("")}
    val tfPersonPhone = remember{ mutableStateOf("")}
    val localFocusManager = LocalFocusManager.current//tf deki focusu kaldırıyor
    val context = LocalContext.current
    val viewModel: PersonRegistrationPageViewModel = viewModel(
        factory = PersonRegistrationPageViewModelFactory(context.applicationContext as Application)
    )
    Scaffold(
        topBar = {
            TopAppBar(title ={ Text(text = "Person Registration") } )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(value = tfPersonName.value,
                    onValueChange = {tfPersonName.value=it},
                    label = { Text(text = "Person Name")})
                TextField(value = tfPersonPhone.value,
                    onValueChange = {tfPersonPhone.value=it},
                    label = { Text(text = "Person Phone")})
                Button(onClick = {
                    val person_name = tfPersonName.value
                    val person_phone =tfPersonPhone.value
                    viewModel.registration(person_name,person_phone)
                    localFocusManager.clearFocus()
                }, modifier = Modifier.size(250.dp,50.dp)) {
                    Text(text = "SAVE")
                }
            }
        }

    )
}