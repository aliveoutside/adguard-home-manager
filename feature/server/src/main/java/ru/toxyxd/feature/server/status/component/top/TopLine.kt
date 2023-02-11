package ru.toxyxd.feature.server.status.component.top

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopLine(
    modifier: Modifier = Modifier,
    leftText: String,
    leftSubText: String? = null,
    rightText: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(text = leftText)
            if (leftSubText != null) {
                Text(text = leftSubText, style = MaterialTheme.typography.bodySmall)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column {
            Text(text = rightText)
        }
    }
}

@Preview
@Composable
private fun TopLinePreview() {
    Column {
        TopLine(leftText = "Left text", rightText = "Right text")
        Spacer(modifier = Modifier.height(16.dp))
        TopLine(
            leftText = "Left text",
            leftSubText = "Left sub text",
            rightText = "Right text",
        )
    }
}