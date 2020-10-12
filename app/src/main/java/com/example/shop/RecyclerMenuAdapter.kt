package com.example.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_menu_view.view.*

class RecyclerMenuAdapter(private  val listMenu: List<Menu>, private val fragment : Fragment) : RecyclerView.Adapter <RecyclerMenuAdapter.MenuViewHolder>() {

    interface MenuClick {
        fun onBtnMenu(btn:String)
    }

    class MenuViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_view, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        Picasso.get().load(listMenu[position].image).into(holder.itemView.menuItemImage)
        holder.itemView.textViewMenu.text=listMenu[position].name

        holder.itemView.item_menu.setOnClickListener {
            val btnMenu = listMenu[position].name
            val nav = fragment as RecyclerMenuAdapter.MenuClick
            nav.onBtnMenu(btnMenu)
        }
    }

    override fun getItemCount() = listMenu.size
}