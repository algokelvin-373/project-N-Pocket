package com.algokelvin.utils.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
class DataViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun setItemListData(setup: Binding<*>.() -> Unit, item: Any?, position: Int) = itemView.run {
        val setupData = Binding(this, item)
        setup(setupData)
    }
}