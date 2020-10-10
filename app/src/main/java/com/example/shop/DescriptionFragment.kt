package com.example.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_description.*


class DescriptionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        descriptionName.text = Catalog.selectedItem.name
        descriptionPrice.text = Catalog.selectedItem.price
        descriptionDescription.text = Catalog.selectedItem.description
        Picasso.get().load(Catalog.selectedItem.photoUrl).into(descriptionImage)
        val nav=findNavController()
        btnAdd.setOnClickListener{
            if (!User.instance.isRegister){
                nav.navigate(R.id.action_fragment_description_to_fragment_registration)
            }else {
                User.instance.setCart.add(Catalog.selectedItem)
                Toast.makeText(view.context, "Added to cart", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }
    }
}