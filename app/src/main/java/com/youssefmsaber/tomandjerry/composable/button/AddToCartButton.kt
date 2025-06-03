package com.youssefmsaber.tomandjerry.composable.button

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer8
import com.youssefmsaber.tomandjerry.ui.theme.ButtonColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LightWhite
import com.youssefmsaber.tomandjerry.ui.theme.Radius16

@Composable
fun AddToCartButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(Radius16),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                stringResource(R.string.add_to_cart),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Medium
                )
            )
            HorizontalSpacer8()
            Canvas(
                modifier = Modifier
                    .size(5.dp) // diameter = 2 * radius
                    .align(Alignment.CenterVertically)
            ) {
                drawCircle(
                    color = LightWhite,
                    radius = size.minDimension / 2
                )
            }
            HorizontalSpacer8()
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "3 cheeses",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = IBM_Plex,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = (0.5).sp,
                        lineHeight = 16.sp
                    )
                )
                Text(
                    "5 cheeses",
                    style = TextStyle(
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 12.sp,
                        fontFamily = IBM_Plex,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = (0.5).sp,
                        lineHeight = 16.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun AddToCartButtonPreview() {
    AddToCartButton()
}