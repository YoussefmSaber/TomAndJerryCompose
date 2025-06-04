package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LightGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.Radius12

@Composable
fun SearchCard(
    modifier: Modifier = Modifier
) {
    var searchValue by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        shape = RoundedCornerShape(Radius12),
        value = searchValue,
        onValueChange = { newValue ->
            searchValue = newValue
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search_normal_icon),
                contentDescription = "Search Icon",
                tint = LightGrayColor
            )
        },
        placeholder = {
            Text(
                stringResource(R.string.search_hint),
                style = TextStyle(
                    color = LightGrayColor,
                    fontSize = 14.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Normal
                )
            )
        },
        modifier = modifier.height(48.dp),

        colors = TextFieldDefaults.colors(
            focusedTextColor = PrimaryColor,
            focusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            focusedTrailingIconColor = PrimaryColor,
            focusedLeadingIconColor = PrimaryColor,
            cursorColor = PrimaryColor,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.White,
        )
    )
}

@Preview
@Composable
private fun SearchCardPreview() {
    SearchCard()
}