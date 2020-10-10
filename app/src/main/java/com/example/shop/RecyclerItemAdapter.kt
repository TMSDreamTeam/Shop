package com.example.shop

import android.util.ArraySet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerItemAdapter(private val set: ArraySet<Item>, private val fragment:Fragment) : RecyclerView.Adapter<RecyclerItemAdapter.ItemViewHolder>() {
    interface ItemClick{
        fun navigateToDescription()
    }
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return  ItemViewHolder(view)

    }

    override fun getItemCount() = set.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Picasso.get().load(set.valueAt(position).photoUrl).into(holder.itemView.item_image)
        holder.itemView.item_name.text=set.valueAt(position).name
        holder.itemView.item_price.text=set.valueAt(position).price
        Catalog.selectedItem=set.valueAt(position)
        holder.itemView.item_container.setOnClickListener {
            val nav= fragment as ItemClick
            nav.navigateToDescription()
        }

    }
}