package com.example.tp

import StringLoader.Load
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : Activity() {

    lateinit var drawingView: PlateauView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Themes = Load(this).StrListload("Th")
        val Questions = Load(this).Questionsload()

        drawingView = findViewById<PlateauView>(R.id.vPlateau)
        val dice = Dice(6)
        val rollButton: Button = findViewById(R.id.lanceDe)
        rollButton.setOnClickListener {
            val pion1 = drawingView.lesPions[0]
            val cases = drawingView.lesCases
            var res = pion1.joue(cases, dice)


            val diceImage: ImageView = findViewById(R.id.imageView)
            val drawableResource = when (res) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription = dice.toString()
        }
    }

    override fun onPause() {
        super.onPause()
        drawingView.pause()
    }

    override fun onResume() {
        super.onResume()
        drawingView.resume()
    }
}
