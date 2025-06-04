package com.youssefmsaber.tomandjerry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.youssefmsaber.tomandjerry.screen.TomAccountScreen
import com.youssefmsaber.tomandjerry.ui.theme.TomAndJerryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TomAndJerryTheme {
//                JerryStoreScreen()
//                SecretEpisodesScreen()
                TomAccountScreen()
//                TomKitchenScreen()
            }
        }
    }
}
