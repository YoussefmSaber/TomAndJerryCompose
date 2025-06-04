package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer4
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.Padding2
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.PriceContainerColor
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius8

@Composable
fun PriceCard(
    oldPrice: String,
    newPrice: String,
    modifier: Modifier = Modifier,
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = PriceContainerColor,
            contentColor = PrimaryColor
        ),
        shape = RoundedCornerShape(Radius8),
        modifier = modifier.height(32.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(Padding8)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(R.drawable.money_bag_icon),
                contentDescription = "Price icon",
                tint = PrimaryColor,
                modifier = Modifier.size(16.dp)
            )
            Row(modifier = Modifier.padding(bottom = Padding2)) {

                HorizontalSpacer4()
                if (newPrice.isNotBlank()) {
                    PriceText(oldPrice, true)
                    PriceText(" $newPrice ")
                } else {
                    PriceText(" $oldPrice ")
                }
                PriceText("cheeses")
            }
        }
    }
}

@Composable
private fun PriceText(value: String, isDashed: Boolean = false) {
    Text(
        value,
        style = TextStyle(
            fontSize = 12.sp,
            fontFamily = IBM_Plex,
            fontWeight = FontWeight.Medium,
            textDecoration = if (isDashed) TextDecoration.LineThrough else null,
            baselineShift = BaselineShift.Superscript,
            textAlign = TextAlign.Center
        ),
    )
}

@Preview
@Composable
private fun PriceCardPreview() {
    PriceCard(
        oldPrice = 0.toString(),
        newPrice = "3"
    )
}