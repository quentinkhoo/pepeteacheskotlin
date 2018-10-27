package com.quentin.is3261.pepeteacheskotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.widget.Toast
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.get

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = PepeSharedPreferences.defaultPrefs(this)

        val cardviewlesson1 = findViewById<CardView>(R.id.cardviewlesson1)
        cardviewlesson1.setOnClickListener {
            val BasicTypesActivity = Intent(this, BasicTypesActivity::class.java)
            startActivity(BasicTypesActivity)
        }

        val cardviewlesson2 = findViewById<CardView>(R.id.cardviewlesson2)
        cardviewlesson2.setOnClickListener {
            val Lesson2Activity = Intent(this, Lesson2Activity::class.java)
            startActivity(Lesson2Activity)
        }

        val cardviewlesson3 = findViewById<CardView>(R.id.cardviewlesson3)
        cardviewlesson3.setOnClickListener {
            Toast.makeText(this, "In progress lo", Toast.LENGTH_LONG).show()
        }

        val arMode = findViewById<CardView>(R.id.cardviewAR_mode)
        arMode.setOnClickListener {

            if (sharedPreferences.get("NumberLesson", false) == true) {
                val myIntent = Intent(this, ARActivity::class.java)
                startActivity(myIntent)
            } else {
                Toast.makeText(this, "You have yet to unlock AR Mode.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
