package com.youssefmsaber.tomandjerry.composable.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius12

@Composable
fun FilterButton(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = PrimaryColor),
        shape = RoundedCornerShape(Radius12),
        modifier = modifier.size(48.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.filter_horizontal_icon),
            contentDescription = "Filter Icon",
            modifier
                .padding(Padding12)
                .fillMaxSize()
        )
    }
}

@Preview
@Composable
fun FilterButtonPreview() {
    FilterButton()
}