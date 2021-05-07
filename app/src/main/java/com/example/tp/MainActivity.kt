package com.example.tp

import StringLoader.Load
import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {


    lateinit var drawingView: PlateauView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawingView = findViewById<PlateauView>(R.id.vPlateau)
        val dice = Dice(6)
        val rollButton: Button = findViewById(R.id.lanceDe)
        var compteurJoueur = 0
        var nbrejoueurs = 4

        rollButton.setOnClickListener {

            val pion1 = drawingView.lesPions[0]
            val pion2 = drawingView.lesPions[1]
            val pion3 = drawingView.lesPions[2]
            val pion4 = drawingView.lesPions[3]
            val cases = drawingView.lesCases
            val res: Int
            val diceImage: ImageView = findViewById(R.id.imageView)
            val myToast: Toast

            when {
                compteurJoueur%nbrejoueurs == 0 -> {
                    res = pion1.joue(cases,dice)
                    compteurJoueur += 1
                    myToast = Toast.makeText(this, "Joueur 1 a joué", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,600)
                    myToast.show()
                    if(cases[pion1.pionDonnePosition()] !is CaseFin) {
                        onQuestion(drawingView, pion1)
                    }
                    else if(cases[pion1.pionDonnePosition()] is CaseFin){
                        onGagne(drawingView)
                    }

                }
                compteurJoueur%nbrejoueurs == 1 -> {
                    res = pion2.joue(cases,dice)
                    compteurJoueur +=1
                    myToast = Toast.makeText(this, "Joueur 2 a joué", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,600)
                    myToast.show()
                    if(cases[pion2.pionDonnePosition()] !is CaseFin) {
                        onQuestion(drawingView, pion2)
                    }
                    else if(cases[pion2.pionDonnePosition()] is CaseFin){
                        onGagne(drawingView)
                    }

                }
                compteurJoueur%nbrejoueurs == 2 -> {
                    res = pion3.joue(cases,dice)
                    compteurJoueur +=1
                    myToast = Toast.makeText(this, "Joueur 3 a joué", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,600)
                    myToast.show()
                    if(cases[pion3.pionDonnePosition()] !is CaseFin) {
                        onQuestion(drawingView, pion3)
                    }
                    else if(cases[pion3.pionDonnePosition()] is CaseFin){
                        onGagne(drawingView)
                    }
                }
                else -> {
                    res = pion4.joue(cases,dice)
                    compteurJoueur +=1
                    myToast = Toast.makeText(this, "Joueur 4 a joué", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,600)
                    myToast.show()
                    if(cases[pion4.pionDonnePosition()] !is CaseFin) {
                        onQuestion(drawingView, pion4)
                    }
                    else if(cases[pion4.pionDonnePosition()] is CaseFin){
                        onGagne(drawingView)
                    }
                }
            }


            val drawableResource = when (res) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription = dice.toString()
        }

        val rulesButton: Button = findViewById(R.id.button_rules)
        rulesButton.setOnClickListener {
            showRules(drawingView)
        }

    }

    override fun onPause() {
        super.onPause()
        drawingView.pause()
    }

    override fun onResume() {
        super.onResume()
        drawingView.resume()
    }

    fun onQuestion(view : View, pion: Pion){ //le view en attribut n'est pas nécessaire ?
        var case = drawingView.lesCases[pion.pionDonnePosition()]
        var sup = Question("sup", mutableListOf())
        var index:Int
        if(case is CaseAction) {
            Timer().schedule(700) {
                case = drawingView.lesCases[pion.pionDonnePosition()]
                QuestionFragment(pion, case as CaseTheme).show(supportFragmentManager, "QuestionFragment")
                index= (case as CaseTheme).caseThemeDonneTheme().themeDonneQuestions().indexOf(sup)
                for(it in drawingView.lesCases){
                    if(it is CaseTheme)
                        if(it.caseThemeDonneTheme()== (case as CaseTheme).caseThemeDonneTheme())
                            it.caseThemeDonneTheme().themeDonneQuestions().remove(sup)
                }



            }
        }
        else{
            QuestionFragment(pion, case as CaseTheme).show(supportFragmentManager, "QuestionFragment")

            index= (case as CaseTheme).caseThemeDonneTheme().themeDonneQuestions().indexOf(sup)
            for(it in drawingView.lesCases){
                if(it is CaseTheme)
                    if(it.caseThemeDonneTheme()== (case as CaseTheme).caseThemeDonneTheme())
                        it.caseThemeDonneTheme().themeDonneQuestions().remove(sup)
            }
        }
    }

    fun showRules(view : View){
        RulesFragment().show(supportFragmentManager, "RulesFragment")
    }

    fun onGagne(view: View){
        GagneFragment(drawingView.lesPions).show(supportFragmentManager, "GagneFragment")
    }
}