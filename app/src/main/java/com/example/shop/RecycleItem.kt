package com.example.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerItemAdapter(private val setItem: List<Item>) : RecyclerView.Adapter<RecyclerItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout., parent, false)
        return  ItemViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  setItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }
}