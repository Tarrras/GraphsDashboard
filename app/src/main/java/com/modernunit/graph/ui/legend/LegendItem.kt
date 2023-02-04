package com.modernunit.graph.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.modernunit.graph.ui.model.GraphData

@Composable
fun LegendItem(
    modifier: Modifier = Modifier,
    data: GraphData
) {
    Row(
        modifier = modifier
            .padding(12.dp)
            .semantics(mergeDescendants = true) { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(data.color)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = data.label)
    }
}