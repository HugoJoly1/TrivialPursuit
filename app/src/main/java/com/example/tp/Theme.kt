package com.example.tp

class Theme (private val nom: String, private val couleur: String,
             private val questions: MutableList<Question>){

    fun themeDonneNom(): String{
        return nom
    }

    fun themeDonneQuestions(): MutableList<Question>{
        return questions
    }

    fun themeDonneCouleur(): String{
        return couleur
    }
}