package ru.toxyxd.feature.server.status.component.chart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.toxyxd.adguardhome.domain.usecase.server.GetServerHome
import ru.toxyxd.common_ui.component.GrayLineSpacer
import ru.toxyxd.feature.server.R

@Composable
fun StatusCharts(
    homePage: GetServerHome.ServerHomePage,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        GrayLineSpacer()
        StatusChart(
            title = stringResource(R.string.dns_queries),
            total = homePage.stats.numDnsQueries,
            color = Color.Blue,
            chartData = homePage.stats.dnsQueries,
            timeUnits = homePage.stats.timeUnits
        )
        GrayLineSpacer()
        StatusChart(
            title = stringResource(R.string.blocked_by_filters),
            total = homePage.stats.numBlockedFiltering,
            color = Color.Red,
            chartData = homePage.stats.blockedFiltering,
            timeUnits = homePage.stats.timeUnits
        )
        GrayLineSpacer()
        StatusChart(
            title = stringResource(R.string.blocked_by_parental),
            total = homePage.stats.numReplacedParental,
            color = Color.Green,
            chartData = homePage.stats.replacedParental,
            timeUnits = homePage.stats.timeUnits
        )
        GrayLineSpacer()
        StatusChart(
            title = stringResource(R.string.blocked_by_safebrowsing),
            total = homePage.stats.numReplacedSafebrowsing,
            color = Color.Yellow.copy(green = 0.5f),
            chartData = homePage.stats.replacedSafebrowsing,
            timeUnits = homePage.stats.timeUnits
        )
    }
}

@Composable
private fun StatusChart(
    title: String,
    total: Int? = null,
    color: Color,
    chartData: List<Int>,
    timeUnits: String
) {
    val shouldShowChart = total != null && total > 0
    Column(
        modifier = Modifier.height(
            if (shouldShowChart) 200.dp else 20.dp
        )
    ) {
        Row {
            Text(title, style = MaterialTheme.typography.bodyLarge)
            total?.let {
                Spacer(modifier = Modifier.weight(1f))
                Text(it.toString(), color = color, style = MaterialTheme.typography.bodyLarge)
            }
        }
        if (shouldShowChart) {
            Spacer(modifier = Modifier.height(16.dp))
            Box(contentAlignment = Alignment.BottomStart, modifier = Modifier.weight(1f)) {
                LineChart(
                    data = chartData,
                    graphColor = color,
                    timeUnits = timeUnits,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
fun StatusChartPreview() {
    StatusChart(
        title = "DNS Queries",
        total = 123,
        color = Color.Blue,
        chartData = listOf(5, 3, 2, 7, 10, 1, 3, 4),
        timeUnits = "h"
    )
}