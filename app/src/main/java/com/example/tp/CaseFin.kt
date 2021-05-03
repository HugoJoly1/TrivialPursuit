package com.example.tp

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class CaseFin(x1: Float, y1: Float, x2: Float, y2: Float, numero: Int) : Case(x1, y1, x2, y2, numero) {

    private val nom = "Arrivée"
    private val couleurFond = Color.argb(255, 254, 254, 226)
    private val couleurTexte = Color.BLACK
    private val paintText = Paint()

    override fun draw(canvas: Canvas) {
        paint.color = couleurFond
        paintText.color = couleurTexte
        paintText.textSize = 50f
        canvas.drawRect(r,paint)
        canvas.drawText(nom, this.x1+10f, this.y2+50f, paintText)
    }

}