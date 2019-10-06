package com.mainor.kmandmiles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var km = findViewById<EditText>(R.id.mainactivity_kilometers)
        var mi = findViewById<EditText>(R.id.mainactivity_miles)
        var kmText = findViewById<TextView>(R.id.mainactivity_textview_kilometers)
        var miText = findViewById<TextView>(R.id.mainactivity_textview_miles)

        kmText.setOnClickListener {
            km.visibility = View.VISIBLE
            mi.visibility = View.GONE
            miText.visibility = View.VISIBLE
            kmText.visibility = View.GONE
        }
        miText.setOnClickListener {
            mi.visibility = View.VISIBLE
            km.visibility = View.GONE
            kmText.visibility = View.VISIBLE
            miText.visibility = View.GONE
        }

        km.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mi.visibility = View.INVISIBLE
                miText.visibility = View.VISIBLE
                miText.text = ""

            }

            override fun afterTextChanged(p0: Editable?) {
                if (km.text.isNotEmpty())
                    miText.text = ((km.text.toString().toDouble()* Companion.MILES_TO_KM).toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })

        mi.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                km.visibility = View.INVISIBLE
                kmText.visibility = View.VISIBLE
                kmText.text = ""
            }

            override fun afterTextChanged(p0: Editable?) {
                if (mi.text.isNotEmpty())
                    kmText.text = ((mi.text.toString().toDouble()/Companion.MILES_TO_KM).toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })

    }

    companion object {
        const val MILES_TO_KM = 1.609344
    }
}
