package com.youssefmsaber.tomandjerry.data

import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.entity.Stats
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryGreen
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryPink
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryYellow
import com.youssefmsaber.tomandjerry.ui.theme.SecondPriceContainerColor
import com.youssefmsaber.tomandjerry.ui.theme.SecondaryGreen
import com.youssefmsaber.tomandjerry.ui.theme.SecondaryPink
import com.youssefmsaber.tomandjerry.ui.theme.SecondaryYellow

val statsItems = listOf(
    Stats(
        name = "No. of quarrels",
        value = "2M 12K",
        progressPercentage = 0.67f,
        mainColor = PrimaryColor,
        secondaryColor = SecondPriceContainerColor,
        icon = R.drawable.evil_icon
    ), Stats(
        name = "Chase time",
        value = "+500 h",
        progressPercentage = 0.20f,
        mainColor = PrimaryGreen,
        secondaryColor = SecondaryGreen,
        icon = R.drawable.workout_run_icon
    ), Stats(
        name = "Hunting times",
        value = "2M 12K",
        progressPercentage = 0.90f,
        mainColor = PrimaryPink,
        secondaryColor = SecondaryPink,
        icon = R.drawable.sad_icon
    ), Stats(
        name = "Heartbroken",
        value = "3M 7K",
        progressPercentage = 0.15f,
        mainColor = PrimaryYellow,
        secondaryColor = SecondaryYellow,
        icon = R.drawable.heartbreak_icon
    )
)