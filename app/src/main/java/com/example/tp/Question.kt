package com.example.tp

import android.app.Application
import android.content.Context

data class Question (var enoncé:String, var réponses: List<String> ) {

    fun Valider (reponse: String): Boolean {
        return reponse==réponses[0]
    }


}
