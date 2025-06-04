package com.youssefmsaber.tomandjerry.data

import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.entity.CharacterDetails
import com.youssefmsaber.tomandjerry.ui.theme.JerryColor
import com.youssefmsaber.tomandjerry.ui.theme.LittleMouseColor
import com.youssefmsaber.tomandjerry.ui.theme.TomColor

val popularCharacters = listOf(
    CharacterDetails(
        R.drawable.tom,
        "Tom",
        "Failed stalker ",
        TomColor
    ),
    CharacterDetails(
        R.drawable.jerry,
        "Jerry",
        "A scammer mouse",
        JerryColor
    ),
    CharacterDetails(
        R.drawable.little_mouse,
        "Jerry",
        "Hungry mouse",
        LittleMouseColor
    )
)