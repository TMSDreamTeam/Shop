package com.example.shop


data class Item(
    val name: String,
    val price: String,
    val photoUrl: String,
    val description: String

)

class User private constructor(){

    var login: String =""
    var password: String = ""
    var isRegister =false
    val setCart = ArrayList<Item>()

    companion object {
        val instance = User()
    }
}


