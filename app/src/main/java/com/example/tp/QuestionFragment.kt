package com.example.tp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.questions_layout.*
import kotlinx.android.synthetic.main.questions_layout.view.*

class QuestionFragment(val theme:Theme) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {





        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner)
        return inflater.inflate(R.layout.questions_layout, container, false)

    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        val question = theme.Questions.random()
        val titre = question.enoncé
        val reponses = question.réponses.shuffled()
        textQuestion.text = titre
        Reponse1.text = reponses[1]
        Reponse2.text = reponses[2]
        Reponse3.text = reponses[3]
        Reponse4.text = reponses[0]
        couleurfond.setBackgroundColor(Color.parseColor(theme.Couleur))


    }
}