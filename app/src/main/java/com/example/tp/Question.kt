package com.example.tp

import android.app.Application
import android.content.Context

data class Question (val Enoncé:String, val Réponses: List<String> ) {

    fun Valider (Réponse: String): Boolean {
        return Réponse==Réponses[1]
    }


}
