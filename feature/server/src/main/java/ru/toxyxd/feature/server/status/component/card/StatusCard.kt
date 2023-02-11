package ru.toxyxd.feature.server.status.component.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.toxyxd.common_ui.ext.DarkGreen

@Composable
fun StatusCard(
    icon: @Composable () -> Unit,
    title: String,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    val color = if (enabled) {
        StatusColor.Green
    } else {
        StatusColor.Red
    }

    Surface(
        shape = CardDefaults.shape,
        color = color,
        contentColor = Color.White,
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(end = 8.dp)) {
                icon()
            }
            Column {
                Text(text = title, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

private object StatusColor {
    val Green = Color.DarkGreen()
    val Red = Color.Red.copy(alpha = 0.8f)
}

@Preview
@Composable
private fun StatusCardPreview() {
    Column {
        StatusCard(
            icon = {
                Icon(
                    Icons.Rounded.Home,
                    contentDescription = "Filtering status"
                )
            },
            enabled = true,
            title = "Filtering \nstatus"
        )
        StatusCard(
            icon = {
                Icon(
                    Icons.Rounded.Home,
                    contentDescription = "Filtering status"
                )
            },
            enabled = false,
            title = "Filtering \nstatus"
        )
    }
}