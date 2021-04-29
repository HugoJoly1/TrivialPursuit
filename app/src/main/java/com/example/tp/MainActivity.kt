package com.example.tp

import StringLoader.Load
import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : Activity() {


    lateinit var drawingView: PlateauView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawingView = findViewById<PlateauView>(R.id.vPlateau)
        val dice = Dice(6)
        val rollButton: Button = findViewById(R.id.lanceDe)
        var compteurJoueur = 0
        rollButton.setOnClickListener {
            val pion1 = drawingView.lesPions[0]
            val pion2 = drawingView.lesPions[1]
            val pion3 = drawingView.lesPions[2]
            val pion4 = drawingView.lesPions[3]
            val cases = drawingView.lesCases
            val res: Int
            val diceImage: ImageView = findViewById(R.id.imageView)
            val myToast: Toast
            when {
                compteurJoueur%4 == 0 -> {
                    res = pion1.joue(cases,dice)
                    compteurJoueur += 1
                    myToast = Toast.makeText(this, "Joueur 1 a joué", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,600)
                    myToast.show()
                }
                compteurJoueur%4 == 1 -> {
                    res = pion2.joue(cases,dice)
                    compteurJoueur +=1
                    myToast = Toast.makeText(this, "Joueur 2 a joué", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,600)
                    myToast.show()
                }
                compteurJoueur%4 == 2 -> {
                    res = pion3.joue(cases,dice)
                    compteurJoueur +=1
                    myToast = Toast.makeText(this, "Joueur 3 a joué", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,600)
                    myToast.show()
                }
                else -> {
                    res = pion4.joue(cases,dice)
                    compteurJoueur +=1
                    myToast = Toast.makeText(this, "Joueur 4 a joué", Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.CENTER_HORIZONTAL,0,600)
                    myToast.show()
                }
            }


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
