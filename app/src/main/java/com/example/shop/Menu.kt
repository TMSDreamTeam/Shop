package com.example.shop

data class Menu(
    val image: String,
    val name: String,
)

object MenuSet {

    fun getMenu() = listOf<Menu>(
        Menu(
            "https://png.pngtree.com/png-clipart/20200831/original/pngtree-mobile-phone-mobile-device-color-electronic-screen-png-image_5473966.jpg",
            "Phone"
        ),
        Menu(
            "https://png.pngtree.com/png-clipart/20190905/original/pngtree-hand-drawn-grey-tv-illustration-png-image_4525664.jpg",
            "Tv"
        ),
        Menu(
            "https://c7.hotpng.com/preview/774/844/42/headphones-icon-vector-headphones.jpg",
            "Headphones"
        )
    )
}