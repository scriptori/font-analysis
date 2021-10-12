package com.example.fontanalysis.util

import android.content.Context
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.text.TextPaint
import com.example.fontanalysis.R
import kotlin.math.ceil

object TextUtil {
    fun getTextSize(context: Context, text: String, font: Typeface): IntArray {
        return IntArray(2).also { tb ->
            getTextPaint(context, font).also { tp ->
                tb[0] = ceil(tp.measureText(text)).toInt()
                tb[1] = getAscDescBounds(tp).height()
            }
        }
    }

    fun getTextPaint(context: Context, font: Typeface): TextPaint {
        // Create textPaint object
        val fontHeightInPixels = context.resources.getDimensionPixelSize(
            R.dimen.text_size
        ) * 116 / 72
        return TextPaint().apply {
            typeface = font
            textSize = fontHeightInPixels.toFloat()
            textAlign = Paint.Align.LEFT
            setARGB(255, 255, 255, 255)
            isAntiAlias = true
        }
    }

    private fun getAscDescBounds(textPaint: TextPaint): Rect {
        val rect = Rect()
        textPaint.getTextBounds("Wgh龍漢", 0, 5, rect)
        return rect
    }
}
