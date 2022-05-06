package com.example.personsapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"


        fun getPersonDaoInterface():PersonsDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(PersonsDaoInterface::class.java)
        }
    }
}