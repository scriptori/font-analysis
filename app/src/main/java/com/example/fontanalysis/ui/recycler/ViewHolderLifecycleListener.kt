package com.example.fontanalysis.ui.recycler

import androidx.recyclerview.widget.RecyclerView

/**
 * Denotes an object that can be notified throughout a ViewHolder's lifecycle.
 */
interface ViewHolderLifecycleListener {
    /**
     * This default implementation returns false.
     *
     * @see [RecyclerView.Adapter.onViewRecycled]
     */
    fun onFailedToRecycleView() = false

    /**
     * This default implementation does nothing.
     *
     * @see [RecyclerView.Adapter.onViewRecycled]
     */
    fun onViewAttachedToWindow() {}

    /**
     * This default implementation does nothing.
     *
     * @see [RecyclerView.Adapter.onViewRecycled]
     */
    fun onViewDetachedFromWindow() {}

    /**
     * This default implementation does nothing.
     *
     * @see [RecyclerView.Adapter.onViewRecycled]
     */
    fun onViewRecycled() {}
}

