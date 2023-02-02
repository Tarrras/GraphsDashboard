package com.modernunit.graph.ui.screen

import com.modernunit.graph.data.GraphsDataFactory
import com.modernunit.graph.ui.model.GraphData
import com.modernunit.graph.ui.model.GraphType

data class GraphsState(
    val selectedChart: GraphType = GraphType.LINE,
    val showChartPicker: Boolean = false,
    val chartData: List<GraphData> = GraphsDataFactory.makeChartData()
)
