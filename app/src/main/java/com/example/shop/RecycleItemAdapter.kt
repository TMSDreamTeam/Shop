package com.example.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerItemAdapter(private val list: List<Item>) : RecyclerView.Adapter<RecyclerItemAdapter.ItemViewHolder>() {
    interface ItemClick{
        fun onItemClick(position: Int)

    }
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return  ItemViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Picasso.get().load(list[position].photoUrl).into(holder.itemView.item_image)
        holder.itemView.item_name.text=list[position].name
        holder.itemView.item_price.text=list[position].price
        Catalog.selectedItem=list[position]
    }
}