package com.youssefmsaber.tomandjerry.data

import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.entity.CheapTom

fun cheapTomItems(): List<CheapTom> {
    return listOf(
        CheapTom(
            id = 1,
            title = "Sport Tom",
            subtitle = "He runs 1 meter... trips over his boot.",
            newPrice = "3",
            oldPrice = "5",
            image = R.drawable.sport_tom,
        ),
        CheapTom(
            id = 2,
            title = "Tom the lover",
            subtitle = "He loves one-sidedly... and is beaten by the other side.",
            oldPrice = "5",
            image = R.drawable.tom_the_lover,
        ),
        CheapTom(
            id = 3,
            title = "Tom the bomb",
            subtitle = "He blows himself up before Jerry can catch him.",
            oldPrice = "10",
            image = R.drawable.tom_the_bomb,
        ),
        CheapTom(
            id = 4,
            title = "Spy Tom",
            subtitle = "Disguises itself as a table.",
            oldPrice = "12",
            image = R.drawable.spy_tom,
        ),
        CheapTom(
            id = 5,
            title = "Frozen Tom",
            subtitle = "He was chasing Jerry, he froze after the first look",
            oldPrice = "10",
            image = R.drawable.frozen_tom,
        ),
        CheapTom(
            id = 6,
            title = "Sleeping Tom",
            subtitle = "He doesn't chase anyone, he just snores in stereo.",
            oldPrice = "10",
            image = R.drawable.sleeping_tom,
        ),
    )
}