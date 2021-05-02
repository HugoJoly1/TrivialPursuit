package com.example.tp

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class CaseTheme( x1: Float, y1: Float, x2: Float, y2: Float,numero: Int, val Theme:Theme): Case(x1, y1, x2, y2, numero) {
    //On pourrait mettre le listTheme.random() directement lorsqu'on invoque la casetheme dans le plateau view comme ça on fait pas tout passer à chaque fois



    var couleurFond = Color.parseColor(Theme.Couleur)
    var couleurNum = R.color.black
    val paintNum = Paint()


    override fun draw(canvas: Canvas) {
        paint.color = couleurFond
        paintNum.color = couleurNum
        paintNum.textSize = 50f
        canvas.drawRect(r,paint)
        canvas.drawText(numero.toString(),x1+10f, y2+50f, paintNum)

    }

}