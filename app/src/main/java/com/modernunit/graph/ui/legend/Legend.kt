package com.modernunit.graph.ui.legend

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.modernunit.graph.data.GraphsDataFactory
import com.modernunit.graph.ui.model.GraphData
import com.modernunit.graph.ui.screen.LegendItem
import com.modernunit.graph.ui.theme.GraphsDashboardTheme

@Composable
fun Legend(
    modifier: Modifier = Modifier,
    chartData: List<GraphData>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(chartData, key = { it.label }) {
            LegendItem(data = it, modifier = Modifier.wrapContentWidth())
        }
    }
}

@Preview
@Composable
fun LegendPreview() {
    GraphsDashboardTheme {
        Surface {
            Legend(
                chartData = GraphsDataFactory.makeChartData()
            )
        }
    }
}