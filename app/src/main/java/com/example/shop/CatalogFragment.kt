package com.example.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_catalog.*



class CatalogFragment : Fragment(),RecyclerItemAdapter.ItemClick {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val viewManager = LinearLayoutManager(context)
        val viewAdapter = RecyclerItemAdapter(Catalog.catalogTemp,this)

        recyclerView_catalog.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.cart -> {
                    val nav = findNavController()
                    if (User.instance.isRegister) {
                        nav.navigate(R.id.action_fragment_catalog_to_fragment_cart)
                    }
                    else{
                        nav.navigate(R.id.action_fragment_catalog_to_fragment_registration)
                    }
                    true
                }
                else -> true
            }
        }



    }

    override fun navigateToDescription() {
        val nav=findNavController()
        nav.navigate(R.id.action_fragment_catalog_to_fragment_description)
    }
}