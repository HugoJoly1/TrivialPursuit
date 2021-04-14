package com.example.tp

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import java.util.*
import kotlin.concurrent.schedule

class Pion(val x1: Float,val y1: Float, val joueur: Int) {

    val diametre = 30f
    val r = RectF(x1, y1, x1+diametre, y1+diametre)
    val paint = Paint()
    var couleur = Color.BLACK
    var position = 0


    fun attribueCouleur() {
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
    fun avance(caseDebut: Case){
        val dx = 200f
        val dy = 200f
        if (caseDebut.numero < 3 || caseDebut.numero in 10..12){
            r.offset(dx,0f)
        } else if(caseDebut.numero in 3..4 || caseDebut.numero in 8..9|| caseDebut.numero in 13..14){
            r.offset(0f,dy)
        } else if(caseDebut.numero in 5..7|| caseDebut.numero in  15..17){
            r.offset(-dx, 0f)
        }else{
            r.offset(0f,0f)
        }
        position += 1

    }
    fun joue(cases: Array<Case>, dice: Dice): Int{
        var resultatDe = dice.roll()
        for(i in 1..resultatDe){
            if(position< cases.size)
                avance(cases[position])
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
        return resultatDe
    }

    fun reculeCase(caseDebut: Case){
        val dx = 200f
        val dy = 200f
        if (caseDebut.numero in 1..3 || caseDebut.numero in 11..13){
            r.offset(-dx,0f)
        } else if(caseDebut.numero in 4..5 || caseDebut.numero in 9..10 || caseDebut.numero in 14..15){
            r.offset(0f,-dy)
        } else if(caseDebut.numero in 6..8|| caseDebut.numero in 16..18){
            r.offset(dx, 0f)
        }else{
            r.offset(0f,0f)
        }
        position -= 1
    }

    fun messagePasDeChance(canvas: Canvas?){
        // Trouver comment le rendre non permanent
        val message = "Pas de chance! Recule d'une case"
        val x = 500f
        val y = 1700f

        val paintMessage = Paint()
        paintMessage.color = Color.BLACK
        paintMessage.textSize = 70f

        canvas?.drawText(message,x,y,paintMessage)
    }

}