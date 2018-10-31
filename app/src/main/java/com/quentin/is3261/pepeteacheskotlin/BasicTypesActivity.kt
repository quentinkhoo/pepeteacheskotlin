package com.quentin.is3261.pepeteacheskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.MenuItem
import android.widget.Button

class BasicTypesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_types)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val numberButton = findViewById<CardView>(R.id.card_numbers)
        numberButton.setOnClickListener {
            val numberIntent = Intent(this, BasicTypesNumbersLessonActivity::class.java)
            startActivity(numberIntent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}
