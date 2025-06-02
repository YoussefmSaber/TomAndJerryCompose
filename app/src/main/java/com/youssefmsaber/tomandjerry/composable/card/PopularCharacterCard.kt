package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer4
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.entity.CharacterDetails
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.LighterDarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.ROBOTO
import com.youssefmsaber.tomandjerry.ui.theme.Radius16
import com.youssefmsaber.tomandjerry.ui.theme.SecondaryYellow

@Composable
fun PopularCharacterCard(
    characterDetails: CharacterDetails
) {
    Box(
        modifier = Modifier
            .height(116.dp)
            .width(140.dp)
    ) {
        Box(
            modifier = Modifier
                .background(
                    characterDetails.backgroundColor,
                    shape = RoundedCornerShape(Radius16)
                )
                .height(90.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
        CharacterDetails(characterDetails, modifier = Modifier.align(Alignment.TopCenter))
    }
}

@Composable
private fun CharacterDetails(
    characterDetails: CharacterDetails, modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(characterDetails.image),
                contentDescription = "Tom image",
                modifier = Modifier.size(64.dp)
            )
            VerticalSpacer8()
            Text(
                characterDetails.name,
                style = TextStyle(
                    color = DarkGrayColor,
                    fontSize = 18.sp,
                    fontFamily = ROBOTO,
                    fontWeight = FontWeight.SemiBold,
                )
            )
            VerticalSpacer4()
            Text(
                characterDetails.role,
                style = TextStyle(
                    color = LighterDarkGrayColor,
                    fontSize = 12.sp,
                    fontFamily = ROBOTO,
                    fontWeight = FontWeight.SemiBold,
                )
            )
        }
    }
}

@Preview
@Composable
private fun PopularCharacterCardPreview() {
    PopularCharacterCard(
        CharacterDetails(
            R.drawable.tom,
            "Tom",
            "Failed stalker",
            SecondaryYellow
        )
    )
}