package com.basecamp.kotlin.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter

fun Animator.animationStart(func: () -> Unit) {
    addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationStart(animation: Animator) {
            super.onAnimationStart(animation)
            func()
        }
    })
}

fun Animator.animationEnd(func: () -> Unit) {
    addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)
            func()
        }
    })
}
