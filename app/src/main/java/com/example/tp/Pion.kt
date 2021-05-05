package com.example.tp

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import java.text.ParsePosition
import java.util.*
import kotlin.concurrent.schedule
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

class Pion(private val x1: Float,private val y1: Float, private val joueur: Int, private var score: Int = 0) {

    private val diametre = 30f
    private val r = RectF(x1, y1, x1+diametre, y1+diametre)
    private val paint = Paint()
    private var couleur = Color.BLACK
    private var position = 0


    private fun attribueCouleur() {
        when (joueur){
            1 -> couleur = Color.argb(255, 9, 106, 9)
            2 -> couleur = Color.argb(255, 217, 1, 21)
            3 -> couleur = Color.argb(255, 135, 233, 144)
            4 -> couleur = Color.argb(255, 225, 117, 0)
        }
    }

    fun draw(canvas: Canvas?){
        attribueCouleur()
        paint.color = couleur
        canvas?.drawOval(r,paint)
    }

    private fun avance(caseDebut: Case){
        val dx = 200f
        val dy = 200f
        val numero = caseDebut.caseDonneNumero()

        if (numero < 3 || numero in 10..12){
            r.offset(dx,0f)
        } else if(numero in 3..4 || numero in 8..9|| numero in 13..14){
            r.offset(0f,dy)
        } else if(numero in 5..7||numero in  15..17){
            r.offset(-dx, 0f)
        }
        else{
            r.offset(0f,0f)
        }
        position += 1

    }

    private fun reculeCase(caseDebut: Case) {
        val dx = 200f
        val dy = 200f
        val numero = caseDebut.caseDonneNumero()

        if (numero in 1..3 || numero in 11..13) {
            r.offset(-dx, 0f)
        } else if (numero in 4..5 || numero in 9..10 || numero in 14..15) {
            r.offset(0f, -dy)
        } else if (numero in 6..8 || numero in 16..18) {
            r.offset(dx, 0f)
        } else {
            r.offset(0f, 0f)
        }
        position -= 1
    }

    fun stop(case: Case){
        r.offset(0f,0f)
    }

    fun joue(cases: Array<Case>, dice: Dice): Int{

        var resultatDe = dice.roll()
        if (position + resultatDe <= cases.size){
            for(i in 1..resultatDe){
                if(position< cases.size) {
                    avance(cases[position])
                }
                else{
                    break
                }
            }
            if (cases[position] is CaseAction){
                //var myToast: Toast

                Timer().schedule(600) {
                    reculeCase(cases[position])
                    //myToast = Toast.makeText(this, "Pas de chance! Recule d'une case", Toast.LENGTH_LONG)
                    //myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,0)
                    //myToast.show()
                }

            }
            else if(cases[position] is CaseFin){
                stop(cases[position])
            }
        }
        else{
           for(i in 1..(cases.size-position-1)){
               if(position< cases.size) {
                   avance(cases[position])
               }
               else{
                   break
               }
           }
            if (cases[position] is CaseAction){
                //var myToast: Toast

                Timer().schedule(600) {
                    reculeCase(cases[position])
                    //myToast = Toast.makeText(this, "Pas de chance! Recule d'une case", Toast.LENGTH_LONG)
                    //myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,0)
                    //myToast.show()
                }

            }
            else if(cases[position] is CaseFin){
                stop(cases[position])
            }

        }

        return resultatDe
    }


    fun bonneReponse(resultat: Boolean): Int{

        if(resultat){
            score += 1
        }
        return score
    }

    fun pionDonnePosition(): Int{
        return position
    }

    fun pionDonneScore(): Int{
        return score
    }

}