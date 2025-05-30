package com.youssefmsaber.tomandjerry.composable.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.youssefmsaber.tomandjerry.R
import com.youssefmsaber.tomandjerry.ui.theme.GrayBorderColor
import com.youssefmsaber.tomandjerry.ui.theme.OffsetNegative4
import com.youssefmsaber.tomandjerry.ui.theme.Padding8
import com.youssefmsaber.tomandjerry.ui.theme.PrimaryColor
import com.youssefmsaber.tomandjerry.ui.theme.StrokeWidth1

@Composable
fun NotificationCard(
    numberOfNotifications: Int,
    modifier: Modifier = Modifier
) {
    BadgedBox(
        modifier = modifier.padding(Padding8),
        badge = {
            Badge(
                containerColor = PrimaryColor,
                contentColor = Color.White,
                modifier = modifier.offset(y = OffsetNegative4)
            ) {
                Text(numberOfNotifications.toString())
            }
        }
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            border = BorderStroke(width = StrokeWidth1, color = GrayBorderColor)
        ) {
            Icon(
                painter = painterResource(R.drawable.notification_icon),
                contentDescription = "Notification Icon",
                modifier = modifier.padding(Padding8),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationCardPreview() {
    NotificationCard(3)
}