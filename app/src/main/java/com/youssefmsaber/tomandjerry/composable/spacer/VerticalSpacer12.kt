package com.youssefmsaber.tomandjerry.composable.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.youssefmsaber.tomandjerry.ui.theme.Padding12

@Composable
fun VerticalSpacer12() {
    Spacer(modifier = Modifier.height(Padding12))
}