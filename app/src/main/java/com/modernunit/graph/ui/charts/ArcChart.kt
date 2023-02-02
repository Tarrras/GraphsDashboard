package com.modernunit.graph.ui.charts

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.modernunit.graph.R
import com.modernunit.graph.data.GraphsDataFactory
import com.modernunit.graph.ui.model.GraphData
import com.modernunit.graph.ui.theme.GraphsDashboardTheme
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ArcChart(
    modifier: Modifier = Modifier,
    chartData: List<GraphData>,
    useCenter: Boolean,
    style: DrawStyle,
    outerMargin: Float = 0f
) {
    val labelTextSize = LocalContext.current.resources
        .getDimensionPixelSize(R.dimen.label_size)


    val radiusBorder = with(LocalDensity.current) {
        24.dp.toPx()
    }

    val labelTextPaint = remember {
        Paint().apply {
            textSize = labelTextSize.toFloat()
            textAlign = Paint.Align.CENTER
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
    }

    val sumOfDataSet = remember(chartData) {
        chartData.sumOf { it.value }
    }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Canvas(
            modifier = Modifier.size(240.dp)
        ) {
            val radius = size.width / 2
            var currentSegment = 0f
            val totalAngle = 360

            chartData.forEach { chartData ->
                val segmentAngle = totalAngle *
                        chartData.value / sumOfDataSet
                drawArc(
                    color = chartData.color,
                    startAngle = currentSegment,
                    sweepAngle = segmentAngle.toFloat(),
                    useCenter = useCenter,
                    style = style
                )
                currentSegment += segmentAngle

                drawIntoCanvas {
                    val medianAngle = (currentSegment - (segmentAngle / 2)) * Math.PI / 180f
                    val radiusWithBorder = radius + radiusBorder
                    val drawAtX =
                        ((radiusWithBorder + outerMargin) * cos(medianAngle)).toFloat() + radius
                    val drawAtY =
                        ((radiusWithBorder + outerMargin) * sin(medianAngle)).toFloat() + radius
                    it.nativeCanvas.drawText(
                        chartData.value.toString(),
                        drawAtX,
                        drawAtY,
                        labelTextPaint
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArcChartPreview() {
    GraphsDashboardTheme {
        ArcChart(
            chartData = GraphsDataFactory.makeChartData(),
            useCenter = false,
            style = Stroke(240f)
        )
    }
}