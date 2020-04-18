package com.algokelvin.utils.recyclerview

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun <T> RecyclerView.setupAdapterData(layout: Int, context: Context, list: ArrayList<T>, setData: AdapterDataSetup<T>.() -> Unit) {
    setData(AdapterDataSetup(layout, context, list, this))
}

@Suppress("UNCHECKED_CAST")
class AdapterDataSetup<T>(layout: Int, context: Context, val list: ArrayList<T>, private val recyclerView: RecyclerView) {
    private val gridLayoutManager = "GRID LAYOUT MANAGER"
    private val default = "DEFAULT"
    private var adapterData = AdapterDataGeneral(layout, context, list)

    fun linearLayoutManager(): String = default

    fun data(data: Binding<T>.() -> Unit) {
        adapterData.setData(data as Binding<*>.() -> Unit)
    }

    fun setLayoutManager(layoutManager: String, grid: Int) {
        when(layoutManager) {
            gridLayoutManager -> recyclerView.layoutManager = GridLayoutManager(recyclerView.context, grid)
            default -> recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        }
    }

    fun setAdapter() {
        recyclerView.adapter = adapterData
    }
}