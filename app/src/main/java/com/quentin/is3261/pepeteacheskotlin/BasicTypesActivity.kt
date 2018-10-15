package com.quentin.is3261.pepeteacheskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BasicTypesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_types)

        val numberButton = findViewById<Button>(R.id.butt_numbers)
        numberButton.setOnClickListener {
            val numberIntent = Intent(this, BasicTypesNumbersLessonActivity::class.java)
            startActivity(numberIntent)
        }
    }
}
