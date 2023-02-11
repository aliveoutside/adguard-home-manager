package ru.toxyxd.adguardhome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.toxyxd.adguardhome.ui.screens.AppNavigation
import ru.toxyxd.adguardhome.ui.theme.Template2Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Template2Theme {
                AppNavigation()
            }
        }
    }
}