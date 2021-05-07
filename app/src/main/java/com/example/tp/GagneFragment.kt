package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.gagne_layout.*

class GagneFragment(val pions: Array<Pion>): DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner)
        return inflater.inflate(R.layout.gagne_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        resultatJoueur1.text = pions[0].pionDonneScore().toString()
        resultatJoueur2.text = pions[1].pionDonneScore().toString()
        resultatJoueur3.text = pions[2].pionDonneScore().toString()
        resultatJoueur4.text = pions[3].pionDonneScore().toString()
    }
}