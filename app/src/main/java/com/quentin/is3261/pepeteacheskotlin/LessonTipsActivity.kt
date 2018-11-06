package com.quentin.is3261.pepeteacheskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ViewFlipper

class LessonTipsActivity : AppCompatActivity() {

    private lateinit var viewFlipper: ViewFlipper
    private lateinit var cross: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_tips)

        var currentIndex = 0

        viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        cross = findViewById<ImageView>(R.id.cross_image)
        viewFlipper.setOnClickListener {
            if (currentIndex == 1) {
                finish()
            }
            viewFlipper.showNext()
            currentIndex++
        }

        cross.setOnClickListener{
            finish()
        }

    }
}
