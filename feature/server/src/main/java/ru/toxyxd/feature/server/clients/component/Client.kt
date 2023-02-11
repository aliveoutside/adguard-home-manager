package ru.toxyxd.feature.server.clients.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChildCare
import androidx.compose.material.icons.rounded.ChildFriendly
import androidx.compose.material.icons.rounded.FilterAlt
import androidx.compose.material.icons.rounded.FilterAltOff
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.SearchOff
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.VpnLock
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.toxyxd.adguardhome.domain.model.clients.Client
import ru.toxyxd.feature.server.R
import java.util.Locale

@Composable
fun Client(
    client: Client,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
        ) {
            Row {
                Text(
                    text = client.name,
                    fontSize = 18.sp,
                )
                ClientIcon(
                    deviceTag = client.tags.first(), modifier = Modifier.padding(start = 4.dp),
                )
            }
            Text(text = client.ids.first())

            Row(
                modifier = Modifier.padding(top = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Icon(
                    if (client.filteringEnabled) Icons.Rounded.FilterAlt else Icons.Rounded.FilterAltOff,
                    contentDescription = stringResource(id = R.string.rule_filtering),
                    tint = if (client.filteringEnabled) Color.Green else Color.Red,
                )
                Icon(
                    Icons.Rounded.VpnLock,
                    contentDescription = stringResource(id = R.string.safe_browsing),
                    tint = if (client.safebrowsingEnabled) Color.Green else Color.Red,
                )
                Icon(
                    if (client.parentalEnabled) Icons.Rounded.ChildFriendly else Icons.Rounded.ChildCare,
                    contentDescription = stringResource(id = R.string.parental_filtering),
                    tint = if (client.parentalEnabled) Color.Green else Color.Red,
                )
                Icon(
                    if (client.safesearchEnabled) Icons.Rounded.Search else Icons.Rounded.SearchOff,
                    contentDescription = stringResource(id = R.string.safe_search),
                    tint = if (client.safesearchEnabled) Color.Green else Color.Red,
                )
                if (client.useGlobalSettings) {
                    val usesGlobalSettings =
                        stringResource(id = R.string.uses) + " " + stringResource(
                            id = R.string.global_settings
                        ).lowercase(
                            Locale.getDefault()
                        )
                    Icon(
                        Icons.Rounded.Settings,
                        contentDescription = usesGlobalSettings,
                        tint = Color.Green,
                    )
                    Text(
                        text = usesGlobalSettings,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.align(
                            Alignment.CenterVertically
                        )
                    )
                }
            }
        }
    }
}