package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius12

@Composable
fun FilterCard(modifier: Modifier = Modifier) {
    FilledIconButton(
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = PrimaryColor,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(Radius12),
        modifier = modifier.size(48.dp),
        onClick = {}
    ) {
        Icon(
            painter = painterResource(R.drawable.filter_horizontal_icon),
            contentDescription = "Filter Icon",
            Modifier
                .padding(Padding12)
                .fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun FilterCardPreview() {
    FilterCard()
}