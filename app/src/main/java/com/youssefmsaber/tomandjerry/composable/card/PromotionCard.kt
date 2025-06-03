package com.youssefmsaber.tomandjerry.composable.card

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LinearGradientTomPromotion
import com.youssefmsaber.tomandjerry.ui.theme.OffWhiteTextColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.Radius16
import com.youssefmsaber.tomandjerry.ui.theme.VeryLightWhite

@SuppressLint("UnrememberedMutableState")
@Composable
fun PromotionCard(
    modifier: Modifier = Modifier
) {
    Box(modifier) {

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(92.dp)
                .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
                .clip(RoundedCornerShape(16.dp))
                .align(Alignment.BottomCenter)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = LinearGradientTomPromotion,
                            start = Offset.Zero,
                        )
                    )
            ) {
                PromotionText(Modifier) // pass new Modifier

                Canvas(modifier = Modifier.matchParentSize()) {
                    drawCircle(
                        color = VeryLightWhite,
                        radius = 200f,
                        center = Offset(size.width * 0.95f, size.height * 0.7f)
                    )

                    drawCircle(
                        color = VeryLightWhite,
                        radius = 180f,
                        center = Offset(size.width * 0.95f, size.height * 0.7f)
                    )
                }
            }
        }

        TomImage(Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
private fun PromotionText(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxHeight()
            .padding(Padding12)
    ) {
        Text(
            stringResource(R.string.by_1_tom_and_get_2_for_free),
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.SemiBold
            )
        )
        VerticalSpacer8()
        Text(
            stringResource(R.string.adopt_tom_free_fail_free_guarantee),
            style = TextStyle(
                color = OffWhiteTextColor,
                fontSize = 12.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Normal
            ),
        )
    }
}

@Composable
private fun TomImage(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(R.drawable.tom_promotion),
        contentDescription = "Tom promotion",
        modifier = modifier
            .clip(RoundedCornerShape(Radius16))
            .height(108.dp)
    )
}

@Preview
@Composable
private fun PromotionCardPreview() {
    PromotionCard()
}