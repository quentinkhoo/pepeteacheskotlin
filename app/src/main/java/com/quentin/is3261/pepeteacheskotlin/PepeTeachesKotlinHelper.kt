package com.quentin.is3261.pepeteacheskotlin

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.graphics.Color
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.get
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import nl.dionsegijn.konfetti.KonfettiView

class PepeTeachesKotlinHelper {

    fun throwConfetti(konfetti: KonfettiView) {
        konfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(nl.dionsegijn.konfetti.models.Shape.RECT, nl.dionsegijn.konfetti.models.Shape.CIRCLE)
                .addSizes(nl.dionsegijn.konfetti.models.Size(12))
                .setPosition(-50f, konfetti.width + 50f, -50f, -50f)
                .streamFor(300, 5000L)
    }

    fun promptTips(context: Context) {
        val sharedPreferences = PepeSharedPreferences.defaultPrefs(context)
        if (sharedPreferences.get("hasPrompted", false)?: false == false) {
            val promptTipsIntent = Intent(context, LessonTipsActivity::class.java)
            context.startActivity(promptTipsIntent)
            //sharedPreferences.set("hasPrompted", true)
        }
    }
}