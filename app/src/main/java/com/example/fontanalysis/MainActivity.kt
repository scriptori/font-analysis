package com.example.fontanalysis

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fontanalysis.model.FontItemData
import com.example.fontanalysis.model.FontType
import com.example.fontanalysis.ui.recycler.FontItemAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fontItems = listOf(
            FontItemData(getString(R.string.regular_font_label), Align.LEFT, FontType.ANF_REGULAR),
            FontItemData(getString(R.string.bold_font_label), Align.LEFT, FontType.ANF_BOLD),
            FontItemData(getString(R.string.bold_center_font_label), Align.CENTER,
                FontType.ANF_BOLD),
            FontItemData(getString(R.string.bold_right_font_label), Align.RIGHT, FontType.ANF_BOLD),
            FontItemData(getString(R.string.italic_left_font_label), Align.LEFT,
                FontType.ANF_ITALIC),
            FontItemData(getString(R.string.italic_left_font_skewed_label), Align.LEFT,
                FontType.ANF_ITALIC, true),
            FontItemData(getString(R.string.italic_center_font_label), Align.CENTER,
                FontType.ANF_ITALIC),
            FontItemData(getString(R.string.italic_center_font_skewed_label), Align.CENTER,
                FontType.ANF_ITALIC, true),
            FontItemData(getString(R.string.italic_right_font_label), Align.RIGHT,
                FontType.ANF_ITALIC),
            FontItemData(getString(R.string.italic_right_font_skewed_label), Align.RIGHT,
                FontType.ANF_ITALIC, true),
            FontItemData(getString(R.string.italic_bold_left_font_label), Align.LEFT,
                FontType.ANF_BOLD_ITALIC),
            FontItemData(getString(R.string.italic_bold_left_font_skewed_label), Align.LEFT,
                FontType.ANF_BOLD_ITALIC, true),
            FontItemData(getString(R.string.italic_bold_center_font_label), Align.CENTER,
                FontType.ANF_BOLD_ITALIC),
            FontItemData(getString(R.string.italic_bold_center_font_skewed_label),
                Align.CENTER, FontType.ANF_BOLD_ITALIC, true),
            FontItemData(getString(R.string.italic_bold_left_font_label), Align.RIGHT,
                FontType.ANF_BOLD_ITALIC),
            FontItemData(getString(R.string.italic_bold_left_font_skewed_label), Align.RIGHT,
                FontType.ANF_BOLD_ITALIC, true)
        )

        findViewById<RecyclerView>(R.id.recyclerView).also {
            it.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            it.adapter = FontItemAdapter(fontItems)
        }
    }
}
