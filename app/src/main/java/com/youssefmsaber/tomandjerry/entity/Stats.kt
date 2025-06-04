package com.youssefmsaber.tomandjerry.entity

import androidx.compose.ui.graphics.Color

data class Stats(
    val progressPercentage: Float, // A value between 0 and 1
    val mainColor: Color,
    val secondaryColor: Color,
    val icon: Int,
    val name: String,
    val value: String
)
