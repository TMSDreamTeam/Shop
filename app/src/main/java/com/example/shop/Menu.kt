package com.example.shop

data class MenuItem(
    val image: String,
    val name: String,
)

object Menu {

    fun getMenu() = listOf<MenuItem>(
        MenuItem(
            "https://png.pngtree.com/png-clipart/20200831/original/pngtree-mobile-phone-mobile-device-color-electronic-screen-png-image_5473966.jpg",
            "Phone"
        ),
        MenuItem(
            "https://png.pngtree.com/png-clipart/20190905/original/pngtree-hand-drawn-grey-tv-illustration-png-image_4525664.jpg",
            "Tv"
        ),
        MenuItem(
            "https://c7.hotpng.com/preview/774/844/42/headphones-icon-vector-headphones.jpg",
            "Headphones"
        )
    )
}