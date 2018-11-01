package com.quentin.is3261.pepeteacheskotlin

import android.content.Context
import android.os.Handler
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.Log
import android.view.animation.Animation
import android.widget.TextView
import android.widget.Toast
import cn.dreamtobe.messagehandler.MessageHandler

class TypeWriter(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    private var textList: List<String> = emptyList()
    private var currentIndex: Int = 0
    private var delay: Long = 150 // in ms
    private val textHandler = Handler()
    private var listener: (() -> Unit)? = null

    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            text = textList.subList(0, currentIndex).joinToString(" ")
            if (currentIndex < textList.size) {
                currentIndex++
                handler.postDelayed(this, delay)
            } else {
                listener?.invoke()
            }
        }
    }

    fun animateText(txt: CharSequence, endAnimationListener: (() -> Unit)? = null) {
        textList = txt.split(Regex("\\s+"))
        currentIndex = 0
        listener = endAnimationListener

        textHandler.removeCallbacks(characterAdder)
        textHandler.postDelayed(characterAdder, delay)
    }

    fun setCharacterDelay(m: Long) {
        delay = m
    }
}