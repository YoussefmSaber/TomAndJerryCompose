package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.data.mostWatchedEpisodes
import com.youssefmsaber.tomandjerry.entity.MostWatched
import com.youssefmsaber.tomandjerry.ui.theme.CheeseColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.ROBOTO
import com.youssefmsaber.tomandjerry.ui.theme.Radius12
import com.youssefmsaber.tomandjerry.ui.theme.Radius16

@Composable
fun MostWatchedCard(episode: MostWatched) {
    Box(
        modifier = Modifier
            .height(310.dp)
            .width(210.dp)
            .clip(RoundedCornerShape(Radius16))
    ) {
        Image(
            painter = painterResource(episode.image),
            contentDescription = "episode image",
            modifier = Modifier.height(310.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(0.8f)
                        )
                    )
                )
                .padding(Padding8)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(
                        color = Color.White.copy(0.24f),
                        shape = RoundedCornerShape(Radius12)
                    )
                    .border(
                        width = 1.dp,
                        color = Color.White.copy(0.5f),
                        shape = RoundedCornerShape(Radius12)
                    )
                    .size(48.dp)

            ) {
                Icon(
                    painter = painterResource(R.drawable.cheese_icon),
                    contentDescription = "Cheese image",
                    tint = CheeseColor,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
            Text(
                episode.title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = ROBOTO,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 20.sp,
                ),
                modifier = Modifier.align(Alignment.BottomStart)
            )
        }
    }
}

@Preview
@Composable
private fun MostWatchedCardPreview() {
    MostWatchedCard(mostWatchedEpisodes[0])
}