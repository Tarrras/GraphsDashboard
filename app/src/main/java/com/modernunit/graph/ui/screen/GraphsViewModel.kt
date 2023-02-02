package com.modernunit.graph.ui.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate

@HiltViewModel
class GraphsViewModel : ViewModel() {

    val uiState = MutableStateFlow(GraphsState())

    fun handleEvent(event: GraphsEvent) {
        when (event) {
            GraphsEvent.DismissPicker ->
                uiState.getAndUpdate { it.copy(showChartPicker = true) }

            GraphsEvent.ShowPicker ->
                uiState.getAndUpdate { it.copy(showChartPicker = false) }

            is GraphsEvent.SetGraphType ->
                uiState.getAndUpdate {
                    it.copy(
                        selectedChart = event.graphType,
                        showChartPicker = false
                    )
                }
        }
    }
}