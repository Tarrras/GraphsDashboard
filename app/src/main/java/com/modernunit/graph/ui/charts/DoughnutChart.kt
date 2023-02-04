package com.modernunit.graph.ui.charts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import com.modernunit.graph.ui.model.GraphData

@Composable
fun DoughnutChart(
    modifier: Modifier = Modifier,
    chartData: List<GraphData>
) {
    ArcChart(
        modifier = modifier,
        chartData = chartData,
        useCenter = false,
        style = Stroke(150f, cap = StrokeCap.Butt),
        outerMargin = 70f
    )
}