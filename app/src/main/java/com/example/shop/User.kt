package com.example.shop

data class Item(
    val name: String,
    val price: String,
    val description: String,
    val photoUrl: String
)

class User private constructor(){

    val login: String =""
    val password: String = ""
    val isRegister =false
    val setCart = ArrayList<Item>()

    companion object {
        val instance = User()
    }
}


