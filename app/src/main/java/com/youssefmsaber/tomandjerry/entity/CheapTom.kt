package com.youssefmsaber.tomandjerry.entity

data class CheapTom(
    val id: Int,
    val title: String,
    val subtitle: String,
    val newPrice: String = "",
    val oldPrice: String,
    val image: Int
)