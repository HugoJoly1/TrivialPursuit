package com.example.tp

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

abstract class Case(protected val x1: Float, protected val y1: Float,
                    protected val x2: Float, protected val  y2: Float,
                    protected val numero: Int) {

    protected val r = RectF(x1, y1, x2, y2) // RectF(gauche, haut, droite, bas)
    protected val paint = Paint()


    abstract fun draw(canvas: Canvas)

    fun caseDonneNumero(): Int{
        return numero
    }
}