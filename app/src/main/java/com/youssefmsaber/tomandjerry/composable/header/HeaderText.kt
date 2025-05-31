package com.youssefmsaber.tomandjerry.composable.header

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayTextColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.SubHeaderTextColor

@Composable
fun HeaderText(
    name: String
) {
    Column {
        Text("Hi, $name \uD83D\uDC4B\uD83C\uDFFB",
            style = TextStyle(
                color = DarkGrayTextColor,
                fontSize = 14.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Medium
            )
        )
        Text("Which Tom do you want to buy?",
            style = TextStyle(
                color = SubHeaderTextColor,
                fontSize = 12.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Normal
            )
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun HeaderTextPreview() {
    HeaderText("Jerry")
}