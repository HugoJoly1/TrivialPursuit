package com.example.tp

data class Question (private var enoncé:String, private var réponses: List<String> ) {

    fun Valider (reponse: String): Boolean {
        return reponse==réponses[0]
    }

    fun questionDonneEnonce(): String{
        return enoncé
    }

    fun questionChangeEnonce(texte : String){
        enoncé = texte
    }

    fun questionDonneReponses(): List<String>{
        return réponses
    }

    fun questionChangeReponses(listReponses: MutableList<String>){
        réponses = listReponses
    }


}

