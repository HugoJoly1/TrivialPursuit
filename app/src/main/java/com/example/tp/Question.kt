package com.example.tp

data class Question (val Thème: String, val Enoncé:String, val Réponses: List<String> ) {

    fun Valider (Réponse: String): Boolean {
        return Réponse==Réponses[1]
    }

}