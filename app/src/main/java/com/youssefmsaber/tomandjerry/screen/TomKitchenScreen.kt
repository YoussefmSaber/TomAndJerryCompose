package com.youssefmsaber.tomandjerry.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.card.DetailsCard
import com.youssefmsaber.tomandjerry.composable.card.PreparationMethodCard
import com.youssefmsaber.tomandjerry.composable.card.PriceCard
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer8
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer12
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer16
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer24
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer32
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer46
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.data.detailsItems
import com.youssefmsaber.tomandjerry.data.preparationItems
import com.youssefmsaber.tomandjerry.ui.theme.ButtonColor
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.DetailsBackgroundColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LightBLueBackgroundColor
import com.youssefmsaber.tomandjerry.ui.theme.LighterDarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.Padding16
import com.youssefmsaber.tomandjerry.ui.theme.Padding24
import com.youssefmsaber.tomandjerry.ui.theme.Padding46
import com.youssefmsaber.tomandjerry.ui.theme.Radius16
import com.youssefmsaber.tomandjerry.ui.theme.SecondPriceContainerColor

@Composable
fun TomKitchenScreen() {
    Scaffold { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .clipToBounds()
                .background(LightBLueBackgroundColor)
        ) {
            val (backgroundImage, content, bottomBar, pasta, tags) = createRefs()
            Image(
                painter = painterResource(R.drawable.ellipse_3),
                contentDescription = "Background Image",
                modifier = Modifier
                    .constrainAs(backgroundImage) {
                        top.linkTo(parent.top, margin = -Padding16)
                        start.linkTo(parent.start)
                    }
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = Padding16)
                    .constrainAs(tags) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            ) {
                VerticalSpacer46()
                MealTags()
            }
            Details(
                modifier = Modifier
                    .constrainAs(content) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(tags.bottom, margin = Padding46)
                    }
            )
            Image(
                painter = painterResource(R.drawable.pasta),
                contentDescription = "Pasta",
                modifier = Modifier
                    .padding(horizontal = Padding24, vertical = Padding16)
                    .constrainAs(pasta) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            )
            BottomBar(
                modifier = Modifier
                    .constrainAs(bottomBar) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
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
            .fillMaxHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = Padding16)
                .fillMaxWidth()
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
    LazyColumn {
        item {
            Text(
                "Preparation method",
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
        }
        items(preparationItems) {
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
            "Details",
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
            horizontalArrangement = Arrangement.SpaceBetween,
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
        "Pasta cooked with a charger cable and sprinkled with questionable cheese. Make sure to unplug it before eating (or not, you decide).",
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
                "Electric Tom pasta",
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
            PriceCard(
                oldPrice = "5",
                newPrice = "",
                color = SecondPriceContainerColor
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
            Button(
                onClick = { },
                shape = RoundedCornerShape(Radius16),
                colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Row {
                    Text(
                        "Add to cart",
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
    }
}

@Composable
private fun MealTags() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ruler_icon),
                contentDescription = "Ruler Icon",
                modifier = Modifier.size(24.dp)
            )
            HorizontalSpacer8()
            Text(
                "High tension",
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
                "Shocking foods",
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

@Preview(showSystemUi = true)
@Composable
fun TomKitchenScreenPreview() {
    TomKitchenScreen()
}