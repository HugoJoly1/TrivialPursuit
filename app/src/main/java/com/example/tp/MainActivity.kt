package com.example.tp

import StringLoader.Load
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Themes = Load(this).StrListload("Th")
        val Questions = Load(this).Questionsload()




    }
}
