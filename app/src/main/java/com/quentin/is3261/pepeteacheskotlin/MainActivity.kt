package com.quentin.is3261.pepeteacheskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardviewlesson1 = findViewById<CardView>(R.id.cardviewlesson1)
        cardviewlesson1.setOnClickListener {
            val BasicTypesActivity = Intent(this, LessonBasicTypesActivity::class.java)
            startActivity(BasicTypesActivity)
        }

        val cardviewlesson2 = findViewById<CardView>(R.id.cardviewlesson2)
        cardviewlesson2.setOnClickListener {
            Toast.makeText(this, "In progress because we are lost children", Toast.LENGTH_LONG).show()
        }

        val cardviewlesson3 = findViewById<CardView>(R.id.cardviewlesson3)
        cardviewlesson3.setOnClickListener {
            Toast.makeText(this, "In progress lo", Toast.LENGTH_LONG).show()
        }
    }
}
