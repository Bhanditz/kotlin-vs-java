package com.basecamp.kotlin.helpers

import android.os.Build
import android.os.Handler

fun atleastLollipop() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP

fun atleastLollipop(func: () -> Unit) {
    if (atleastLollipop()) func()
}

fun atleastMarshmallow() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

fun runDelayed(delay: Long, func: () -> Unit) = Handler().postDelayed({ func() }, delay)
