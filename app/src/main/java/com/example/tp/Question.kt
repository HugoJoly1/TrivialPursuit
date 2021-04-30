package com.example.tp

import android.app.Application
import android.content.Context

data class Question (val enoncé:String, val réponses: List<String> ) {

    fun Valider (reponse: String): Boolean {
        return reponse==réponses[1]
    }


}
