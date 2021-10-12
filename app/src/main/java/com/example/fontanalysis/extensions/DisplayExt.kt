package com.example.fontanalysis.extensions

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue

internal val Number.pxToDp
    get() = this.toFloat() / (Resources.getSystem().displayMetrics.densityDpi.toFloat() /
        DisplayMetrics.DENSITY_DEFAULT)

internal val Number.dpToPx
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(), Resources.getSystem().displayMetrics)

fun Number.spToPx(context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP, this.toFloat(), context.resources.displayMetrics).toInt()
}
