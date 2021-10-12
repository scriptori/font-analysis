package com.example.fontanalysis.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fontanalysis.databinding.FontItemBinding
import com.example.fontanalysis.model.FontItemData

class FontItemAdapter(private val fontItems: List<FontItemData>) :
    RecyclerView.Adapter<FontItemAdapter.FontItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FontItemHolder {
        return FontItemHolder(FontItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: FontItemHolder, position: Int) {
        holder.binding.also { b ->
            fontItems[position].also { d ->
                b.fontItemText.text = d.fontLabel
                b.fontItemView.text = d.text
                b.fontItemView.textAlign = d.textAlign
                b.fontItemView.fontType = d.fontType
                b.fontItemView.isSkewed = d.isSkewed
                b.fontItemView.initProperties()
            }
        }
    }

    override fun getItemCount() = fontItems.size

    class FontItemHolder(vBinding: FontItemBinding) :
        BindingViewHolder<FontItemBinding>(vBinding)
}
