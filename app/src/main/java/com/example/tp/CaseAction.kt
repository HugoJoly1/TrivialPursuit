package com.example.tp

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class CaseAction(x1: Float, y1: Float, x2: Float, y2: Float, numero: Int): Case(x1, y1, x2, y2, numero) {

    val couleurFond = Color.argb(255, 187, 172, 172)
    val couleurNum = Color.BLACK
    val paintNum = Paint()
    val paintText = Paint()

    override fun draw(canvas: Canvas){
        super.draw(canvas)
        paint.color = couleurFond
        paintNum.color = couleurNum
        paintNum.textSize = 50f
        paintText.color = Color.BLACK
        paintText.textSize = 19f

        canvas.drawRect(r,paint)
        canvas.drawText(numero.toString(),x1+10f, y2+50f, paintNum)
        canvas.drawText("Recule d'une case", x1+40f, y2+35f, paintText)
    }
}