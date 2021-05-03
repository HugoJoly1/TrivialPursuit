package com.example.tp

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class CaseTheme( x1: Float, y1: Float, x2: Float, y2: Float,numero: Int, private val theme:Theme): Case(x1, y1, x2, y2, numero) {

    private var couleurFond = Color.parseColor(theme.themeDonneCouleur())
    private var couleurNum = Color.BLACK
    private val paintNum = Paint()


    override fun draw(canvas: Canvas) {
        paint.color = couleurFond
        paintNum.color = couleurNum
        paintNum.textSize = 50f
        canvas.drawRect(r,paint)
        canvas.drawText(numero.toString(),x1+10f, y2+50f, paintNum)
    }

    fun caseThemeDonneTheme(): Theme{
        return theme
    }

}