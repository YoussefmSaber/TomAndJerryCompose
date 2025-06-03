package com.youssefmsaber.tomandjerry.composable.header

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayTextColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.SubHeaderTextColor

@Composable
fun HeaderText(
    name: String
) {
    Column {
        Text(
            stringResource(R.string.hi, name),
            style = TextStyle(
                color = DarkGrayTextColor,
                fontSize = 14.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Medium
            )
        )
        Text(
            stringResource(R.string.which_tom_do_you_want_to_buy),
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