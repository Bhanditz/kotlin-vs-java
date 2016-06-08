package com.basecamp.kotlin.extensions

import android.content.Context
import android.support.annotation.ColorRes
import com.basecamp.kotlin.helpers.atleastMarshmallow

/**
 * Returns a color without a theme applied across API levels.
 */
@Suppress("DEPRECATION")
fun Context.color(@ColorRes id: Int) = when {
    atleastMarshmallow() -> resources.getColor(id, null)
    else -> resources.getColor(id)
}
