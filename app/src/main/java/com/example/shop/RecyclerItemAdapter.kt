package com.example.shop


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerItemAdapter(private val list: ArrayList<Item>, private val fragment:Fragment) : RecyclerView.Adapter<RecyclerItemAdapter.ItemViewHolder>() {
    interface ItemClick{
        fun navigateToDescription()
    }
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return  ItemViewHolder(view)

    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Picasso.get().load(list[position].photoUrl).into(holder.itemView.item_image)
        holder.itemView.item_name.text=list[position].name
        holder.itemView.item_price.text=list[position].price
        holder.itemView.item_container.setOnClickListener {
            Catalog.selectedItem=list[position]
            val nav= fragment as ItemClick
            nav.navigateToDescription()
        }

    }
}