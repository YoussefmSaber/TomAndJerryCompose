package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer2
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer8
import com.youssefmsaber.tomandjerry.entity.Stats
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LighterDarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius12
import com.youssefmsaber.tomandjerry.ui.theme.SecondPriceContainerColor
import com.youssefmsaber.tomandjerry.ui.theme.VeryLightDarkGrayColor
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun StatsCard(stats: Stats) {
    Box(
        modifier = Modifier
            .background(stats.secondaryColor, shape = RoundedCornerShape(Radius12))
            .width(165.dp)
            .height(56.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(horizontal = Padding12, vertical = Padding8)
                .fillMaxSize()
        ) {
            CircularProgressBar(stats)
            HorizontalSpacer8()
            Column(
            ) {
                Text(
                    stats.value,
                    style = TextStyle(
                        color = LighterDarkGrayColor,
                        fontSize = 16.sp,
                        fontFamily = IBM_Plex,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 16.sp,
                        letterSpacing = (0.5).sp
                    )
                )
                HorizontalSpacer2()
                Text(
                    stats.name,
                    style = TextStyle(
                        color = VeryLightDarkGrayColor,
                        fontSize = 12.sp,
                        fontFamily = IBM_Plex,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 16.sp,
                        letterSpacing = (0.5).sp
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun StatsCardPreview() {
    StatsCard(
        Stats(
            name = "No. of quarrels",
            value = "2M 12K",
            progressPercentage = 0.7f,
            mainColor = PrimaryColor,
            secondaryColor = SecondPriceContainerColor,
            icon = R.drawable.evil_icon
        )
    )
}


@Composable
private fun CircularProgressBar(
    stats: Stats
) {
    val circleSize = 40.dp
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(circleSize)
            .background(Color.White, shape = CircleShape)
    ) {

        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasSize = size.minDimension
            val radius = canvasSize / 2
            val arcRadius = radius - 1.dp.toPx() / 2f
            val startAngle = -90f
            val sweepAngle = 360 * stats.progressPercentage

            // Draw arc
            drawArc(
                color = stats.mainColor,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 1.dp.toPx(), cap = StrokeCap.Round),
            )

            // Compute dot position at the END of the arc
            val angleInRad = Math.toRadians((startAngle + sweepAngle).toDouble())
            val dotX = center.x + arcRadius * cos(angleInRad).toFloat()
            val dotY = center.y + arcRadius * sin(angleInRad).toFloat()

            drawCircle(
                color = stats.mainColor,
                radius = 4.dp.toPx(),
                center = Offset(dotX, dotY)
            )
        }

        Image(
            painter = painterResource(stats.icon),
            contentDescription = "Icon",
            modifier = Modifier.size(24.dp),
        )
    }
}