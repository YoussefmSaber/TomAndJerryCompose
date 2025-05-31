package com.youssefmsaber.tomandjerry.composable.header

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer4
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor

@Composable
fun ViewAllText() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "View all",
            style = TextStyle(
                color = PrimaryColor,
                fontSize = 12.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Medium
            )
        )
        HorizontalSpacer4()
        Icon(
            painter = painterResource(R.drawable.arrow_right),
            contentDescription = "View All Icon",
            tint = PrimaryColor
        )
    }
}

@Preview
@Composable
private fun ViewAllTextPreview() {
    ViewAllText()
}