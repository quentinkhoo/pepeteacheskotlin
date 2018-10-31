package com.quentin.is3261.pepeteacheskotlin

import android.graphics.Color
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
}