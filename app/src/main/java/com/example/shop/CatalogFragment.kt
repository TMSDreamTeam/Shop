package com.example.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class CatalogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val names=resources.getStringArray(R.array.product_names)
        val prices=resources.getStringArray(R.array.product_prices)
        val urls=resources.getStringArray(R.array.product_image_urls)
        val descriptions=resources.getStringArray(R.array.product_descriptions)
        for (i in 0..names.size){
            Catalog.catalog.add(Item(names[i],prices[i],urls[i],descriptions[i]))

        }
    }


}