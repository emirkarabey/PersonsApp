package com.example.personsapp

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.personsapp.entity.Persons
import com.example.personsapp.ui.theme.PersonsAppTheme
import com.example.personsapp.viewmodel.HomePageViewModel
import com.example.personsapp.viewmodelfactory.HomePageViewModelFactory
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyNavigation()
                }
            }
        }
    }
}
@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homepage"){
        composable("homepage"){
            HomePage(navController = navController)
        }
        composable("person_registration_page"){
            PersonRegistrationPage()
        }
        composable("person_detail_page/{person}", arguments = listOf(
            navArgument("person"){type = NavType.StringType}
        )){
            val json = it.arguments?.getString("person")
            val p = Gson().fromJson(json,Persons::class.java)
            PersonDetailPage(person = p)
        }
    }
}

@Composable
fun HomePage(navController: NavController) {
    val searchControl = remember { mutableStateOf(false) }
    val tf = remember { mutableStateOf("") }
    val context = LocalContext.current
    val viewModel:HomePageViewModel = viewModel(
        factory = HomePageViewModelFactory(context.applicationContext as Application)
    )
    val personsList = viewModel.personList.observeAsState(listOf())

    LaunchedEffect(key1 = true){
        viewModel.loadPersons()
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(searchControl.value){
                        TextField(
                            value = tf.value,
                            onValueChange = {
                                tf.value = it
                                viewModel.search(it)
                            },
                            label = { Text(text = "Search") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                            )
                        )
                    }else{
                        Text(text = "Persons")
                    }
                },
                actions = {
                    if(searchControl.value){
                        IconButton(onClick = {
                            searchControl.value = false
                            tf.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_close_24),
                                contentDescription = "",tint = Color.White)
                        }
                    }else{
                        IconButton(onClick = {
                            searchControl.value = true
                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_search_24),
                                contentDescription = "",tint = Color.White)
                        }
                    }
                }
            )
        },
        content = {
            LazyColumn{
                items(
                    count = personsList.value!!.count(),
                    itemContent = {
                        val person = personsList.value!![it]
                        Card(modifier = Modifier
                            .padding(all = 5.dp)
                            .fillMaxWidth()) {
                            Row(modifier = Modifier.clickable {
                                val personJson = Gson().toJson(person)
                                navController.navigate("person_detail_page/${personJson}")
                            }) {
                                Row(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "${person.person_name} - ${person.person_phone}")

                                    IconButton(onClick = {
                                        viewModel.delete(person.person_id)
                                    }) {
                                        Icon(painter = painterResource(id = R.drawable.ic_baseline_delete_outline_24),
                                            contentDescription = "",tint = Color.Gray)
                                    }
                                }
                            }
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("person_registration_page") },
                backgroundColor = colorResource(id = R.color.teal_200),
                content = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = "",tint = Color.White)
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PersonsAppTheme {

    }
}