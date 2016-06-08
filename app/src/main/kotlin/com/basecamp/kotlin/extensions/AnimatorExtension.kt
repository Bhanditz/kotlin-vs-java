package com.basecamp.kotlin.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter

fun Animator.animationStart(func: () -> Unit): Animator {
    addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationStart(animation: Animator) {
            super.onAnimationStart(animation)
            func()
        }
    })
    return this
}

fun Animator.animationEnd(func: () -> Unit): Animator {
    addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)
            func()
        }
    })
    return this
}
