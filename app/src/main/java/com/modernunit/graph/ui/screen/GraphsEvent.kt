package com.modernunit.graph.ui.screen

import com.modernunit.graph.ui.model.GraphType

sealed interface GraphsEvent {

    object ShowPicker : GraphsEvent

    object DismissPicker : GraphsEvent

    class SetGraphType(val graphType: GraphType) : GraphsEvent
}
