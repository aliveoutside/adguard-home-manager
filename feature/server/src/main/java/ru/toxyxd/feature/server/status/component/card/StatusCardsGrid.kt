package ru.toxyxd.feature.server.status.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Block
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.VpnLock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.toxyxd.adguardhome.domain.usecase.server.GetServerHome
import ru.toxyxd.feature.server.R

@Composable
fun StatusCardsGrid(
    modifier: Modifier = Modifier,
    homePage: GetServerHome.ServerHomePage
) {
    Column(
        modifier = modifier.height(170.dp)
    ) {
        Row(
            modifier = Modifier.weight(0.5f)
        ) {
            StatusCard(
                modifier = Modifier.weight(0.5f),
                icon = {
                    Icon(
                        Icons.Rounded.Home,
                        contentDescription = stringResource(R.string.rule_filtering)
                    )
                },
                title = stringResource(R.string.rule_filtering),
                enabled = homePage.filteringStatus.enabled
            )
            Spacer(modifier = Modifier.width(8.dp))
            StatusCard(
                modifier = Modifier.weight(0.5f),
                icon = {
                    Icon(
                        Icons.Rounded.Search,
                        contentDescription = stringResource(R.string.safe_search)
                    )
                },
                title = stringResource(R.string.safe_search),
                enabled = homePage.safeSearchStatus.enabled
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.weight(0.5f)
        ) {
            StatusCard(
                modifier = Modifier.weight(0.5f),
                icon = {
                    Icon(
                        Icons.Rounded.Block,
                        contentDescription = stringResource(R.string.parental_filtering)
                    )
                },
                title = stringResource(R.string.parental_filtering),
                enabled = homePage.parentalStatus.enabled
            )
            Spacer(modifier = Modifier.width(8.dp))
            StatusCard(
                modifier = Modifier.weight(0.5f),
                icon = {
                    Icon(
                        Icons.Rounded.VpnLock,
                        contentDescription = stringResource(R.string.safe_browsing)
                    )
                },
                title = stringResource(R.string.safe_browsing),
                enabled = homePage.safeBrowsingStatus.enabled
            )
        }
    }
}