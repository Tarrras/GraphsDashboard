package com.modernunit.graph.data

import androidx.compose.ui.graphics.Color
import com.modernunit.graph.ui.model.GraphData

object GraphsDataFactory {
    fun makeChartData(): List<GraphData> {
        return listOf(
            GraphData("2016", 20, Color.Red),
            GraphData("2017", 10, Color.Blue),
            GraphData("2018", 2, Color.Yellow),
            GraphData("2019", 42, Color.Green),
            GraphData("2020", 7, Color.Magenta),
            GraphData("2021", 5, Color.Cyan),
        )
    }
}