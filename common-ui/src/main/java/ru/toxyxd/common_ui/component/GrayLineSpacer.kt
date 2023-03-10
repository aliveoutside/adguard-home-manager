package ru.toxyxd.common_ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GrayLineSpacer() {
    Spacer(modifier = Modifier
        .height(1.dp)
        .background(color = Color.DarkGray)
        .fillMaxWidth())
}