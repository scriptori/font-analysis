package com.example.fontanalysis.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * ViewHolder that uses a ViewBinding to track its Views.
 */
open class BindingViewHolder<B : ViewBinding>(val binding: B) :
    RecyclerView.ViewHolder(binding.root), ViewHolderLifecycleListener
