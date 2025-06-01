package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer8
import com.youssefmsaber.tomandjerry.data.tomSettingsItems
import com.youssefmsaber.tomandjerry.entity.ProfileItem
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.Radius8


@Composable
fun ProfileCard(profileItem: ProfileItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.White, shape = RoundedCornerShape(Radius8))
        ) {
            Image(
                painter = painterResource(profileItem.icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)

            )
        }
        HorizontalSpacer8()
        Text(
            profileItem.title,
            style = TextStyle(
                color = DarkGrayColor,
                fontSize = 16.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Medium,
            )
        )
    }
}

@Preview
@Composable
private fun ProfileCardPreview() {
    ProfileCard(tomSettingsItems[0])
}