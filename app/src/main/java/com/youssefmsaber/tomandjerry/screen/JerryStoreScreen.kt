package com.youssefmsaber.tomandjerry.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
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
import com.youssefmsaber.tomandjerry.composable.avatar.DefaultAvatar
import com.youssefmsaber.tomandjerry.composable.card.CheapTomCard
import com.youssefmsaber.tomandjerry.composable.card.FilterCard
import com.youssefmsaber.tomandjerry.composable.card.NotificationCard
import com.youssefmsaber.tomandjerry.composable.card.PromotionCard
import com.youssefmsaber.tomandjerry.composable.card.SearchCard
import com.youssefmsaber.tomandjerry.composable.header.HeaderText
import com.youssefmsaber.tomandjerry.composable.header.ViewAllText
import com.youssefmsaber.tomandjerry.composable.spacer.HorizontalSpacer8
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer12
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer16
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer24
import com.youssefmsaber.tomandjerry.composable.spacer.VerticalSpacer8
import com.youssefmsaber.tomandjerry.data.cheapTomItems
import com.youssefmsaber.tomandjerry.ui.theme.BackgroundColor
import com.youssefmsaber.tomandjerry.ui.theme.DarkGrayTextColor
import com.youssefmsaber.tomandjerry.ui.theme.IBM_Plex
import com.youssefmsaber.tomandjerry.ui.theme.Padding12
import com.youssefmsaber.tomandjerry.ui.theme.Padding16
import com.youssefmsaber.tomandjerry.ui.theme.Padding8

@Composable
fun JerryStoreScreen() {
    val cheapTomItems = cheapTomItems()
    Scaffold(
        containerColor = BackgroundColor,
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding(),
                start = Padding16,
                end = Padding16
            ),
        ) {
            item {
                VerticalSpacer8()
                HeaderSection()
                VerticalSpacer12()

                SearchAndFilterSection()
                VerticalSpacer24()

                PromotionCard()
                VerticalSpacer24()

                SectionHeader()
                VerticalSpacer16()
            }

            // The Grid Section
            item {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(160.dp),
                    verticalArrangement = Arrangement.spacedBy(Padding12),
                    horizontalArrangement = Arrangement.spacedBy(Padding8),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 1000.dp)
                ) {
                    items(cheapTomItems) {
                        CheapTomCard(it)
                    }
                }
                VerticalSpacer16()
            }
        }
    }
}

@Composable
private fun HeaderSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        DefaultAvatar(image = painterResource(R.drawable.profile_image))
        HorizontalSpacer8()
        HeaderText("Jerry")
        Spacer(Modifier.weight(1f))
        NotificationCard(3)
    }
}

@Composable
private fun SearchAndFilterSection() {
    Row {
        SearchCard(modifier = Modifier.weight(1f))
        HorizontalSpacer8()
        FilterCard()
    }
}

@Composable
private fun SectionHeader() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            "Cheap tom section",
            style = TextStyle(
                color = DarkGrayTextColor,
                fontSize = 20.sp,
                fontFamily = IBM_Plex,
                fontWeight = FontWeight.SemiBold
            )
        )
        Spacer(Modifier.weight(1f))
        ViewAllText()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun JerryStoreScreenPreview() {
    JerryStoreScreen()
}