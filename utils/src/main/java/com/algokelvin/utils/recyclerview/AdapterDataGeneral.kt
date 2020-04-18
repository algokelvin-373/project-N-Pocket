package com.algokelvin.utils.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterDataGeneral<T>(private val layoutItemData: Int, private val context: Context, private val list: ArrayList<T>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var setupData: Binding<*>.() -> Unit
    private var itemData: T? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DataViewHolder(LayoutInflater.from(context).inflate(layoutItemData, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as DataViewHolder
        itemData = list[position]
        if(itemData != null) {
            try {
                itemHolder.setItemListData(setupData, itemData, position)
            }
            catch (e: UninitializedPropertyAccessException) {
                throw IllegalArgumentException("'bind' is not working")
            }
        }
    }

    fun setData(binding: Binding<*>.() -> Unit) {
        this.setupData = binding
    }
}