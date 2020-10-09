package com.example.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerItemAdapter(User.instance.setCart,this)

        if (User.instance.setCart.isNotEmpty()){
        recyclerCart.adapter = adapter
        recyclerCart.layoutManager = LinearLayoutManager(context)
        recyclerCart.hasFixedSize()}

        btnOrder.setOnClickListener {
            if (User.instance.setCart.isNotEmpty()) {
                Toast.makeText(
                    view.context,
                    "Accept order, wait for our manager to contact you",
                    Toast.LENGTH_SHORT
                ).show()
            } else Toast.makeText(view.context, "Your shopping cart is empty", Toast.LENGTH_SHORT)
                .show()
        }
    }
}