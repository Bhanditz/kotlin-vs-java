package com.basecamp.kotlin.extensions

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.support.annotation.ColorRes
import android.view.View
import android.view.ViewAnimationUtils

fun View.backgroundCircle(@ColorRes colorResId: Int) {
    background = ShapeDrawable(OvalShape())
    (background as ShapeDrawable).paint.color = context.color(colorResId)
}

fun View.circularRevealAnimator(centerX: Int, centerY: Int, duration: Long, startDelay: Long = 0): Animator {
    val radius = Math.hypot(centerX.toDouble(), centerY.toDouble()).toFloat()
    val anim = ViewAnimationUtils.createCircularReveal(this, centerX, centerY, 0f, radius)
    anim.duration = duration
    anim.startDelay = startDelay
    visibility = View.VISIBLE
    return anim
}

fun View.circularHideAnimator(centerX: Int, centerY: Int, duration: Long, startDelay: Long = 0): Animator {
    val radius = Math.hypot(centerX.toDouble(), centerY.toDouble()).toFloat()
    val anim = ViewAnimationUtils.createCircularReveal(this, centerX, centerY, radius, 0f)
    anim.duration = duration
    anim.startDelay = startDelay
    anim.animationEnd { visibility = View.INVISIBLE }
    return anim
}

fun View.alphaAnimator(startAlpha: Float, endAlpha: Float, duration: Long, startDelay: Long = 0): ObjectAnimator {
    val anim = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("alpha", startAlpha, endAlpha))
    anim.duration = duration
    anim.startDelay = startDelay
    visibility = View.VISIBLE
    return anim
}
