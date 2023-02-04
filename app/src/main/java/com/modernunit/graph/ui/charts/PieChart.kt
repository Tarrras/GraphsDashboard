package com.modernunit.graph.ui.charts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Fill
import com.modernunit.graph.ui.model.GraphData

@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    chartData: List<GraphData>
) {
    ArcChart(
        modifier = modifier,
        chartData = chartData,
        useCenter = true,
        style = Fill
    )
}