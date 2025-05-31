package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer8
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LightGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.Radius12

@Composable
fun SearchCard(
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(Radius12),
        modifier = modifier
            .height(48.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .padding(Padding8)
                .fillMaxHeight()
        ) {
            Icon(
                painter = painterResource(R.drawable.search_normal_icon),
                contentDescription = "Search Icon",
                tint = LightGrayColor
            )
            HorizontalSpacer8()
            Text(
                text = stringResource(R.string.search_hint),
                style = TextStyle(
                    color = LightGrayColor,
                    fontSize = 14.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

@Preview
@Composable
private fun SearchCardPreview() {
    SearchCard()
}