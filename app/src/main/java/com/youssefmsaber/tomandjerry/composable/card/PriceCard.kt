package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer4
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.PriceContainerColor
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius8

@Composable
fun PriceCard(
    oldPrice: String,
    newPrice: String,
    modifier: Modifier = Modifier,
    color : Color = PriceContainerColor
) {
    val price = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 12.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Medium
            )
        ) {
            if (newPrice.isNotBlank()) {
                withStyle(
                    style = SpanStyle(
                        textDecoration = TextDecoration.LineThrough,
                    )
                ) {
                    append(oldPrice)
                }
                append(" ")
                append(newPrice)
            } else {
                append(oldPrice)
            }
            append(" ")
            append("cheeses")
        }
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = color,
            contentColor = PrimaryColor
        ),
        shape = RoundedCornerShape(Radius8),
        modifier = modifier
            .height(30.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(Padding8),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.money_bag_icon),
                contentDescription = "Price icon",
                tint = PrimaryColor,
                modifier = Modifier.size(16.dp)
            )
            HorizontalSpacer4()
            Text(price)
        }
    }
}

@Preview
@Composable
private fun PriceCardPreview() {
    PriceCard(
        oldPrice = 0.toString(),
        newPrice = ""
    )
}