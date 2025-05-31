package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.button.CartButton
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer8
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.entity.CheapTom
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayTextColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LightGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.Radius16

@Composable
fun CheapTomCard(
    cheapTom: CheapTom,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .height(236.dp)
            .width(160.dp)
    ) {
        Box(
            Modifier
                .height(220.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(Radius16))
                .background(Color.White)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier.padding(start = Padding8, end = Padding8, bottom = Padding8)
        ) {
            TomDetails(cheapTom)
            Spacer(modifier = Modifier.weight(1f))
            Row {
                PriceCard(
                    oldPrice = cheapTom.oldPrice,
                    newPrice = cheapTom.newPrice,
                    modifier = Modifier.weight(3f)
                )
                HorizontalSpacer8()
                CartButton(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun TomDetails(
    cheapTom: CheapTom,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(cheapTom.image),
            contentDescription = cheapTom.title,
        )
        VerticalSpacer8()
        Text(
            cheapTom.title,
            style = TextStyle(
                color = DarkGrayTextColor,
                fontSize = 18.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            cheapTom.subtitle,
            style = TextStyle(
                color = LightGrayColor,
                fontSize = 12.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview
@Composable
private fun CheapTomCardPreview() {
    val cheapTom = CheapTom(
        id = 1,
        title = "Sport Tom",
        subtitle = "He runs 1 meter... trips over his boot.",
        oldPrice = "5",
        newPrice = "3",
        image = R.drawable.sport_tom
    )
    CheapTomCard(cheapTom)
}

