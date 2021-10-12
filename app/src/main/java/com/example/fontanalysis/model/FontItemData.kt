package com.example.fontanalysis.model

import android.graphics.Paint

data class FontItemData(
    val fontLabel: String,
    val textAlign: Paint.Align,
    val fontType: FontType,
    val isSkewed: Boolean = false,
    val text: String = "86000"
)
