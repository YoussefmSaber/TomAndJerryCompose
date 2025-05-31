package com.youssefmsaber.tomandjerry.composable.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius8
import com.youssefmsaber.tomandjerry.ui.theme.StrokeWidth1

@Composable
fun CartButton(
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { },
        modifier = modifier.border(
            width = StrokeWidth1,
            color = PrimaryColor,
            shape = RoundedCornerShape(Radius8)
        ).size(30.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.add_to_cart_icon),
            contentDescription = "Add to cart icon",
            tint = PrimaryColor,
            modifier = Modifier
                .padding(Padding8)
                .fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartButtonPreview() {
    CartButton()
}