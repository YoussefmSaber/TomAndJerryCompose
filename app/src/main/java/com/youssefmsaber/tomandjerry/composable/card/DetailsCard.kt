package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer12
import com.youssefmsaber.tomandjerry.entity.DetailsItem
import com.youssefmsaber.tomandjerry.ui.theme.Elevation0
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LighterDarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.Radius12
import com.youssefmsaber.tomandjerry.ui.theme.SecondPriceContainerColor
import com.youssefmsaber.tomandjerry.ui.theme.VeryLightDarkGrayColor

@Composable
fun DetailsCard(
    item: DetailsItem,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = SecondPriceContainerColor,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = Elevation0),
        shape = RoundedCornerShape(Radius12),
        modifier = modifier.size(104.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(Padding12)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(item.image),
                contentDescription = "Temperature Icon"
            )
            VerticalSpacer12()
            Text(
                item.title,
                style = TextStyle(
                    color = LighterDarkGrayColor,
                    fontSize = 14.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 16.sp,
                    letterSpacing = (0.5).sp
                )
            )
            Text(
                item.description,
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

@Preview
@Composable
fun DetailsCardPreview() {
    DetailsCard(
        DetailsItem(
            image = R.drawable.temperature_icon,
            title = "1000 V",
            description = "Temperature"
        )
    )
}