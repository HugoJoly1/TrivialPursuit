package com.example.tp

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class CaseTheme( x1: Float, y1: Float, x2: Float, y2: Float,numero: Int, val theme: String): Case(x1, y1, x2, y2, numero) {

    var couleurFond = R.color.black
    var couleurNum = R.color.black
    val paintNum = Paint()

    fun defineCouleur(){
        when(theme){
            "litterature" -> couleurFond = Color.argb(255,121, 28, 248)
            "histoire" -> couleurFond = Color.YELLOW
            "sciences" -> couleurFond = Color.GREEN
            "loisir" -> couleurFond = Color.argb(255, 239, 155, 15)
            "geographie" -> couleurFond = Color.argb(255, 49, 140, 231)
            "divertissement" -> couleurFond = Color.MAGENTA
        }

    }

    override fun draw(canvas: Canvas) {
        defineCouleur()
        paint.color = couleurFond
        paintNum.color = couleurNum
        paintNum.textSize = 50f
        canvas.drawRect(r,paint)
        canvas.drawText(numero.toString(),x1+10f, y2+50f, paintNum)

    }
}