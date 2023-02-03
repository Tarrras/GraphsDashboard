package com.modernunit.graph.ui.util

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.TweenSpec
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.modernunit.graph.ui.model.GraphData

@Composable
fun configureAnimation(
    chartData: List<GraphData>
): Animatable<Float, AnimationVector1D> {
    val transitionAnimation = remember(chartData) {
        Animatable(initialValue = 0f)
    }

    LaunchedEffect(chartData) {
        transitionAnimation.animateTo(
            1f,
            animationSpec = TweenSpec(durationMillis = 750)
        )
    }
    return transitionAnimation
}