package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer46
import com.youssefmsaber.tomandjerry.entity.PreparationItem
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LighterDarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.PreparationNumberColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius12
import com.youssefmsaber.tomandjerry.ui.theme.Radius24
import com.youssefmsaber.tomandjerry.ui.theme.SecondPriceContainerColor
import com.youssefmsaber.tomandjerry.ui.theme.StrokeWidth1

@Composable
fun PreparationMethodCard(method: PreparationItem) {
    Box {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .align(Alignment.Center),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(
                topEnd = Radius12,
                bottomEnd = Radius12,
                topStart = Radius24,
                bottomStart = Radius24
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                HorizontalSpacer46()
                Text(
                    method.method,
                    style = TextStyle(
                        color = LighterDarkGrayColor,
                        fontSize = 14.sp,
                        fontFamily = IBM_Plex,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 16.sp,
                        letterSpacing = (0.5).sp
                    )
                )
            }
        }
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = CircleShape,
            border = BorderStroke(
                width = StrokeWidth1,
                color = SecondPriceContainerColor
            ),
            modifier = Modifier.size(36.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    method.number.toString(),
                    style = TextStyle(
                        color = PreparationNumberColor,
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
fun PreparationMethodCardPreview() {
    PreparationMethodCard(
        PreparationItem(
            number = 1,
            method = "Put the pasta in a toaster."
        )
    )
}