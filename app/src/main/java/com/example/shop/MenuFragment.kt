package com.example.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_catalog.topAppBar
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment(),RecyclerMenuAdapter.MenuClick  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val names = resources.getStringArray(R.array.product_names)
        val prices = resources.getStringArray(R.array.product_prices)
        val urls = resources.getStringArray(R.array.product_image_urls)
        val descriptions = resources.getStringArray(R.array.product_descriptions)

        if(Catalog.catalogPhone.isEmpty()) {
            for (i in names.indices) {
                when (i) {
                    in 0..9 -> Catalog.catalogPhone.add(Item(names[i], prices[i], urls[i], descriptions[i]))
                    in 10..19 -> Catalog.catalogTv.add(Item(names[i], prices[i], urls[i], descriptions[i]))
                    in 20..29 -> Catalog.catalogHeadphones.add(Item(names[i], prices[i], urls[i], descriptions[i]))
                }
            }
        }

        val viewManager = LinearLayoutManager(context)
        val viewAdapter = RecyclerMenuAdapter(MenuSet.getMenu(), this)

        recyclerView_Menu.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

            topAppBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.cart -> {
                        val nav = findNavController()
                        if (User.instance.isRegister) {
                            nav.navigate(R.id.action_menuFragment_to_fragment_cart)
                        } else {
                            nav.navigate(R.id.action_menuFragment_to_fragment_registration)
                        }
                        true
                    }
                    else -> true
                }
            }
        }
    }

    override fun onBtnMenu(btn: String){
        Catalog.catalogTemp.clear()
        when(btn) {
            "Phone" -> Catalog.catalogTemp.addAll(Catalog.catalogPhone)
            "Tv" -> Catalog.catalogTemp.addAll(Catalog.catalogTv)
            "Headphones" -> Catalog.catalogTemp.addAll(Catalog.catalogHeadphones)
        }
        findNavController().navigate(R.id.action_menuFragment_to_fragment_catalog)
    }
}