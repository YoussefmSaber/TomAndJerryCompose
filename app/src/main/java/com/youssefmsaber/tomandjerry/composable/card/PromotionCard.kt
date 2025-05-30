package com.youssefmsaber.tomandjerry.composable.card

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.OffWhiteTextColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius16
import com.youssefmsaber.tomandjerry.ui.theme.VeryLightWhite

@SuppressLint("UnrememberedMutableState")
@Composable
fun PromotionCard(
    modifier: Modifier = Modifier
) {
    ConstraintLayout {
        val (image, card) = createRefs()

        BoxWithConstraints(
            modifier = modifier
                .fillMaxWidth()
                .height(92.dp)
                .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
                .clip(RoundedCornerShape(16.dp))
                .constrainAs(card) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            val widthPx = constraints.maxWidth.toFloat()
            val heightPx = constraints.maxHeight.toFloat()

            Box(
                modifier = modifier
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(PrimaryColor, Color(0xFF0685D0)),
                            start = Offset.Zero,
                            end = Offset(widthPx * 2, heightPx)
                        )
                    )
                    .fillMaxSize()
            ) {
                ConstraintLayout(
                    modifier = modifier.fillMaxWidth()
                ) {
                    val (first, second) = createRefs()
                    LightWhiteCircle(
                        modifier
                            .size(140.dp)
                            .constrainAs(first) {
                                bottom.linkTo(parent.bottom, margin = (-8).dp)
                                end.linkTo(parent.end, margin = (-48).dp)
                            }
                    )
                    LightWhiteCircle(
                        modifier
                            .size(130.dp)
                            .constrainAs(second) {
                                bottom.linkTo(parent.bottom, margin = (-8).dp)
                                end.linkTo(parent.end, margin = (-46).dp)
                            }
                    )
                }
                PromotionText(modifier)


            }
        }


        TomImage(modifier.constrainAs(image) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
    }
}

@Composable
fun LightWhiteCircle(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(VeryLightWhite)
    )
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
            "By 1 Tom and get 2 for free",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.SemiBold
            )
        )
        VerticalSpacer8()
        Text(
            "Adopt Tom! (Free Fail-Free\n Guarantee)",
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
fun PromotionCardPreview() {
    PromotionCard()
}