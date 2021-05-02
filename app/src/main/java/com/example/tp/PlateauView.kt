package com.example.tp

import StringLoader.Load
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class PlateauView @JvmOverloads constructor (context: Context,
                                             attributes: AttributeSet? = null,
                                             defStyleAttr: Int = 0):
        SurfaceView(context,attributes,defStyleAttr), SurfaceHolder.Callback, Runnable{

    lateinit var canvas: Canvas

    val backgroundPaint = Paint()
    var listTheme = Load().Themeload()
    var drawing: Boolean = true



    lateinit var thread: Thread
    lateinit var lesCases: Array<Case>
    lateinit var lesPions: Array<Pion>


    init {
        backgroundPaint.color = Color.WHITE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        lesCases = arrayOf(
                CaseDepart(100f,300f,300f,100f,0),
                CaseTheme(300f,300f,500f,100f,1, listTheme.random()),
                CaseTheme(500f,300f,700f,100f,2, listTheme.random()),
                CaseTheme(700f,300f,900f,100f,3, listTheme.random()),
                CaseTheme(700f,500f,900f,300f,4, listTheme.random()),
                CaseTheme(700f,700f,900f,500f,5, listTheme.random()),
                CaseAction(500f,700f,700f,500f,6),
                CaseTheme(300f,700f,500f,500f,7, listTheme.random()),
                CaseTheme(100f,700f,300f,500f,8, listTheme.random()),
                CaseTheme(100f,900f,300f,700f,9, listTheme.random()),
                CaseTheme(100f,1100f,300f,900f, 10, listTheme.random()),
                CaseTheme(300f,1100f,500f,900f, 11, listTheme.random()),
                CaseTheme(500f,1100f,700f,900f, 12, listTheme.random()),
                CaseTheme(700f,1100f,900f,900f,13, listTheme.random()),
                CaseTheme(700f,1300f,900f,1100f,14, listTheme.random()),
                CaseTheme(700f,1500f,900f,1300f,15, listTheme.random()),
                CaseTheme(500f,1500f,700f,1300f,16, listTheme.random()),
                CaseAction(300f,1500f,500f,1300f,17),
                CaseFin(100f,1500f,300f,1300f,18)
        )
        lesPions = arrayOf(
                Pion(150f, 200f, 1),
                Pion(150f, 250f, 2),
                Pion(230f, 200f, 3),
                Pion(230f, 250f, 4)
        )
    }

    fun pause() {
        drawing = false
        thread.join()
    }

    fun resume() {
        drawing = true
        thread = Thread(this)
        thread.start()
    }

    fun draw() {
        if(holder.surface.isValid){
            canvas = holder.lockCanvas()
            canvas.drawRect(0F, 0F, canvas.width*1F, canvas.height*1F, backgroundPaint)
            for (c in lesCases){
                c.draw(canvas)
            }
            for (p in lesPions){
                p.draw(canvas)
            }
            holder.unlockCanvasAndPost(canvas)
        }
    }

    override fun run() {
        while (drawing){
            draw()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        thread = Thread(this)
        thread.start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        thread.join()
    }


}