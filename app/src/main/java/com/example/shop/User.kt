package com.example.shop

import android.util.ArraySet

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
    val setCart = ArraySet<Item>()

    companion object {
        val instance = User()
    }
}


