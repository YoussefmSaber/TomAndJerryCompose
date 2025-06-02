package com.youssefmsaber.tomandjerry.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.composable.avatar.DefaultAvatar
import com.youssefmsaber.tomandjerry.composable.card.ProfileCard
import com.youssefmsaber.tomandjerry.composable.card.StatsCard
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer12
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer16
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.data.favoriteFoodsItems
import com.youssefmsaber.tomandjerry.data.statsItems
import com.youssefmsaber.tomandjerry.data.tomSettingsItems
import com.youssefmsaber.tomandjerry.entity.ProfileItem
import com.youssefmsaber.tomandjerry.ui.theme.BackgroundColor
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.LighterDarkGrayColor
import com.youssefmsaber.tomandjerry.ui.theme.OffsetNegative46
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.Padding16
import com.youssefmsaber.tomandjerry.ui.theme.Padding4
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.Radius20

@Composable
fun TomAccountScreen() {
    Scaffold { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .clipToBounds()
        ) {
            val (backgroundImage, account, content) = createRefs()
            Image(
                painterResource(R.drawable.account_background),
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(backgroundImage) {
                        top.linkTo(parent.top, margin = OffsetNegative46)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
            )
            Account(
                modifier = Modifier.constrainAs(account) {
                    top.linkTo(parent.top, margin = Padding16)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .constrainAs(content) {
                        top.linkTo(account.bottom, margin = Padding4)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .background(BackgroundColor, shape = RoundedCornerShape(Radius20))
                    .fillMaxHeight()
            ) {
                item {

                    VerticalSpacer16()
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(160.dp),
                        verticalArrangement = Arrangement.spacedBy(Padding8),
                        horizontalArrangement = Arrangement.spacedBy(Padding8),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(Padding16)
                            .heightIn(max = 1000.dp)
                    ) {
                        items(statsItems) {
                            StatsCard(it)
                        }
                    }
                }
                item {
                    SettingsSection("Tom settings", tomSettingsItems)
                    VerticalSpacer12()
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0x14001A1F)
                    )
                    VerticalSpacer12()
                    SettingsSection("Favorite foods", favoriteFoodsItems)
                    VerticalSpacer16()
                    Text(
                        "v.TomBeta",
                        style = TextStyle(
                            color = LighterDarkGrayColor,
                            fontSize = 12.sp,
                            fontFamily = IBM_Plex,
                            fontWeight = FontWeight.Normal,
                        )
                    )
                }
            }
        }
    }
}


@Composable
private fun Account(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Padding4),
        modifier = modifier
            .fillMaxWidth()
    ) {
        DefaultAvatar(
            image = painterResource(R.drawable.tom_profile),
            modifier = Modifier.size(64.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Tom",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 16.sp,
                )
            )
            Text(
                "specializes in failure!",
                style = TextStyle(
                    color = Color.White.copy(0.8f),
                    fontSize = 12.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 16.sp,
                )
            )
        }
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(0.12f)
            ),
            shape = CircleShape
        ) {
            Text(
                "Edit foolishness",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 10.sp,
                    fontFamily = IBM_Plex,
                    fontWeight = FontWeight.Medium,
                ),
                modifier = Modifier.padding(
                    horizontal = Padding16,
                    vertical = Padding8
                )
            )
        }
    }
}

@Composable
private fun SettingsSection(title: String, settings: List<ProfileItem>) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Padding16)
    ) {
        Text(
            title,
            style = TextStyle(
                color = DarkGrayColor,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        VerticalSpacer8()
        Column(
            verticalArrangement = Arrangement.spacedBy(Padding12)

        ) {
            settings.forEach {
                ProfileCard(it)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun TomAccountScreenPreview() {
    TomAccountScreen()
}