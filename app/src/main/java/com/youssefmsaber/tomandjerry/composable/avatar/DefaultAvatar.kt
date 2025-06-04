package com.youssefmsaber.tomandjerry.composable.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.ui.theme.Radius12

@Composable
fun DefaultAvatar(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = "Default Avatar",
        modifier = modifier.clip(RoundedCornerShape(Radius12))
    )
}

@Preview
@Composable
private fun DefaultAvatarPreview() {
    DefaultAvatar(image = painterResource(R.drawable.profile_image))
}