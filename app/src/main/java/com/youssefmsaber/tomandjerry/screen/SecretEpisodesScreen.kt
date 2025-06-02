package com.youssefmsaber.tomandjerry.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.avatar.DefaultAvatar
import com.youssefmsaber.tomandjerry.composable.card.MostWatchedCard
import com.youssefmsaber.tomandjerry.composable.card.PopularCharacterCard
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer2
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer12
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer24
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.data.mostWatchedEpisodes
import com.youssefmsaber.tomandjerry.data.popularCharacters
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.LighterDarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.Padding16
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.ROBOTO
import com.youssefmsaber.tomandjerry.ui.theme.Radius12
import com.youssefmsaber.tomandjerry.ui.theme.VerticalGradientBackground
import com.youssefmsaber.tomandjerry.ui.theme.VerticalGradientSearch

@Composable
fun SecretEpisodesScreen() {
    Scaffold { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val heightPx = constraints.maxHeight.toFloat()

            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = VerticalGradientBackground,
                            endY = heightPx / 5 * 4
                        )
                    )
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = Padding16)
                    ) {
                        HeaderSection()
                        VerticalSpacer8()
                        TomAndJerrySection()
                        VerticalSpacer12()
                        MostWatchedSection()
                        VerticalSpacer24()
                        PopularCharacterSection()
                    }
                }
            }
        }
    }
}

@Composable
private fun PopularCharacterSection() {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            "Popular character",
            style = TextStyle(
                color = DarkGrayColor,
                fontSize = 20.sp,
                fontFamily = ROBOTO,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 20.sp,
                letterSpacing = (0.25).sp
            ),
            modifier = Modifier.padding(start = Padding16)
        )
        VerticalSpacer12()
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Padding8),
            contentPadding = PaddingValues(horizontal = Padding16)
        ) {
            items(popularCharacters) {
                PopularCharacterCard(it)
            }
        }
    }
}

@Composable
private fun MostWatchedSection() {
    Column {
        Text(
            "Most watched",
            style = TextStyle(
                color = DarkGrayColor,
                fontSize = 20.sp,
                fontFamily = ROBOTO,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 20.sp,
                letterSpacing = (0.25).sp
            ),
            modifier = Modifier.padding(start = Padding16)
        )
        VerticalSpacer12()
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Padding12),
            contentPadding = PaddingValues(horizontal = Padding16)
        ) {
            items(mostWatchedEpisodes) {
                MostWatchedCard(it)
            }
        }
    }
}

@Composable
private fun TomAndJerrySection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = Padding16)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                "Deleted episodes of Tom and Jerry!",
                style = TextStyle(
                    color = DarkGrayColor,
                    fontSize = 18.sp,
                    fontFamily = ROBOTO,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp,
                    letterSpacing = (0.25).sp
                )
            )
            VerticalSpacer12()
            Text(
                "Scenes that were canceled for... mysterious (and sometimes embarrassing) reasons.",
                style = TextStyle(
                    color = LighterDarkGrayColor,
                    fontSize = 14.sp,
                    fontFamily = ROBOTO,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    letterSpacing = (0.25).sp
                )
            )
        }
        HorizontalSpacer2()
        Image(
            painter = painterResource(R.drawable.tom_and_jerry),
            contentDescription = "Tom and jerry image",
            modifier = Modifier.height(200.dp)
        )
    }
}

@Composable
private fun HeaderSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Padding16)
    ) {
        DefaultAvatar(
            painterResource(R.drawable.profile_image2),
            modifier = Modifier.size(40.dp)
        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = VerticalGradientSearch,
                        endY = 140f
                    ),
                    shape = RoundedCornerShape(Radius12),
                )
                .size(40.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.search_status_icon),
                contentDescription = "Search",
                tint = Color.White
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SecretEpisodesScreenPreview() {
    SecretEpisodesScreen()
}