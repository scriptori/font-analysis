package com.example.fontanalysis.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint.Align
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.fontanalysis.model.FontType
import com.example.fontanalysis.util.FontUtil
import com.example.fontanalysis.util.TextUtil

/**
 * Custom view
 */
class FontItemView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var text: String = ""
    var fontType: FontType = FontType.ANF_REGULAR
    var textAlign: Align = Align.LEFT
    var isSkewed: Boolean = false

    private var initial: Int = 0
    private lateinit var textPaint: TextPaint
    private lateinit var textBound: Rect

    internal fun initProperties() {
        val font = FontUtil.getFont(resources, fontType)
        val rSize = TextUtil.getTextSize(context, text, font)
        textBound = Rect(0, 0, rSize[0], rSize[1])
        textPaint = TextUtil.getTextPaint(context, font).also {
            setInitial()
            it.textAlign = textAlign
            it.textSkewX = when (fontType) {
                FontType.ANF_ITALIC, FontType.ANF_BOLD_ITALIC ->
                    if (isSkewed) -0.25f else 0f
                else -> 0f
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setInitial()
        val yPos = (height - textBound.height()) / 2 // default value for yPos
        val xPos = _xPos
        val left = xPos - (textBound.width() / 2) + textBound.left
        val top = yPos + textBound.top
        val right = xPos - (textBound.width() / 2) + textBound.right
        val bottom = yPos + textBound.bottom
        textPaint.color = Color.YELLOW
        textPaint.strokeWidth = 3f
        canvas.drawRect(left, top.toFloat(), right, bottom.toFloat(), textPaint)
        textPaint.color = Color.BLACK
        canvas.drawText(text, initial.toFloat(),
            (height / 2 + textBound.centerY() / 2).toFloat(), textPaint)
    }

    private fun setInitial() {
        val xDelta = (width - textBound.width()) / 2
        initial = when (textAlign) {
            Align.LEFT -> textBound.left
            Align.CENTER -> (textBound.centerX() + xDelta)
            Align.RIGHT -> (width - textBound.width() + textBound.right)
        }
    }

    private val _xPos: Float
        get() {
            val xDelta = (width - textBound.width()) / 2
            var xPos = width / 2f  // default value for xPos
            when (textAlign) {
                Align.LEFT -> xPos -= xDelta
                Align.CENTER -> {}  // keep default
                Align.RIGHT -> xPos += xDelta
            }
            return xPos
        }
}
