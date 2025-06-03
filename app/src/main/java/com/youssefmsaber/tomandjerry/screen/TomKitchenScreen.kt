package com.youssefmsaber.tomandjerry.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.button.AddToCartButton
import com.youssefmsaber.tomandjerry.composable.card.DetailsCard
import com.youssefmsaber.tomandjerry.composable.card.MealPriceCard
import com.youssefmsaber.tomandjerry.composable.card.PreparationMethodCard
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer8
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer12
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer16
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer24
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer32
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer46
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.data.detailsItems
import com.youssefmsaber.tomandjerry.data.preparationItems
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.DetailsBackgroundColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LightBLueBackgroundColor
import com.youssefmsaber.tomandjerry.ui.theme.LighterDarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding16
import com.youssefmsaber.tomandjerry.ui.theme.Padding24
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.Radius16

@Composable
fun TomKitchenScreen() {
    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) { innerPadding ->
        LazyColumn (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(DetailsBackgroundColor)
                .clipToBounds()
        ) {
            item{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(LightBLueBackgroundColor)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ellipse_3),
                        contentDescription = "Background Image",
                        modifier = Modifier.align(Alignment.TopStart)
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .fillMaxSize()
                    ) {
                        VerticalSpacer46()
                        MealTags()
                        VerticalSpacer24()
                        Details(
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.pasta),
                        contentDescription = "Pasta",
                        modifier = Modifier
                            .padding(horizontal = Padding24, vertical = Padding16)
                            .align(Alignment.TopEnd)
                    )
                }
            }
        }
    }
}


@Composable
private fun Details(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                DetailsBackgroundColor,
                shape = RoundedCornerShape(topStart = Radius16, topEnd = Radius16)
            )
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = Padding16)
        ) {
            TitleDetails()
            VerticalSpacer16()
            MealDescription()
            VerticalSpacer24()
            InformationSection()
            VerticalSpacer24()
            PreparationSection()
        }
    }
}

@Composable
private fun PreparationSection() {
    Column {
        Text(
            stringResource(R.string.preparation_method),
            style = TextStyle(
                color = DarkGrayColor,
                fontSize = 18.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.sp,
                letterSpacing = (0.5).sp
            )
        )
        VerticalSpacer8()
        preparationItems.forEach {
            PreparationMethodCard(it)
            VerticalSpacer8()
        }
    }
}

@Composable
private fun InformationSection() {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            stringResource(R.string.details),
            style = TextStyle(
                color = DarkGrayColor,
                fontSize = 18.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.sp,
                letterSpacing = (0.5).sp
            )
        )
        VerticalSpacer8()
        Row(
            horizontalArrangement = Arrangement.spacedBy(Padding8),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            detailsItems.forEach {
                DetailsCard(it)
            }
        }
    }
}

@Composable
private fun MealDescription() {
    Text(
        stringResource(R.string.pasta_cooked_with_a_charger_cable_and_sprinkled_with_questionable_cheese_make_sure_to_unplug_it_before_eating_or_not_you_decide),
        style = TextStyle(
            color = LighterDarkGrayColor,
            fontSize = 14.sp,
            fontFamily = IBM_Plex,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            letterSpacing = (0.5).sp
        )
    )
}

@Composable
private fun TitleDetails() {
    VerticalSpacer32()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(
                stringResource(R.string.electric_tom_pasta),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Medium,
                    color = DarkGrayColor,
                    letterSpacing = (0.5).sp,
                    lineHeight = 16.sp
                )
            )
            VerticalSpacer12()
            MealPriceCard(
                oldPrice = "5",
                newPrice = "",
            )
        }
        Image(
            painter = painterResource(R.drawable.favorite_icon),
            contentDescription = "Favorite Icon",
        )
    }
}

@Composable
private fun BottomBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.White)
    ) {
        HorizontalDivider()
        Column(
            modifier = Modifier.padding(Padding16)
        ) {
            AddToCartButton()
        }
    }
}

@Composable
private fun MealTags(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(Padding16)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ruler_icon),
                contentDescription = "Ruler Icon",
                modifier = Modifier.size(24.dp)
            )
            HorizontalSpacer8()
            Text(
                stringResource(R.string.high_tension),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Medium
                )
            )
        }
        VerticalSpacer16()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.chef_icon),
                contentDescription = "Ruler Icon",
                modifier = Modifier.size(24.dp)
            )
            HorizontalSpacer8()
            Text(
                stringResource(R.string.shocking_foods),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

@Preview(name = "Default", showSystemUi = true)
@Preview(
    name = "Huawei Y9 Prime 2019",
    showSystemUi = true,
    widthDp = 442,
    heightDp = 958
)
@Composable
fun TomKitchenScreenPreview() {
    TomKitchenScreen()
}