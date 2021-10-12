package com.example.fontanalysis.util

import android.content.res.Resources
import android.graphics.Typeface
import com.example.fontanalysis.R
import com.example.fontanalysis.model.FontType

object FontUtil {
    fun getFont(resources: Resources, fontType: FontType): Typeface {
        return when (fontType) {
            FontType.ANF_REGULAR -> resources.getFont(R.font.avefr)
            FontType.ANF_ITALIC -> resources.getFont(R.font.avefi)
            FontType.ANF_BOLD -> resources.getFont(R.font.avefb)
            FontType.ANF_BOLD_ITALIC -> resources.getFont(R.font.avefbi)
        }
    }
}
