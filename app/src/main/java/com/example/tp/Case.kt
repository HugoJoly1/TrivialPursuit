package com.example.tp

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

abstract class Case(val x1: Float, val y1: Float, val x2: Float, val  y2: Float, val numero: Int) {

    val r = RectF(x1, y1, x2, y2) // RectF(gauche, haut, droite, bas)
    val paint = Paint()


    open fun draw(canvas: Canvas) {

    }
}