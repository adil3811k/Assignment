package com.example.assignment.presentation.uiElement.cmoponent

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircleComposable(
    modifier: Modifier = Modifier
) {
    val sweepAngle = 270f
    Box(
        modifier = Modifier
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        // Outer Circle
        Canvas(modifier = Modifier.size(200.dp)) {
            drawCircle(
                color = Color(0xFFFFCC80), // Orange
                style = Stroke(width = 20f)
            )
        }

        // Inner Progress Circle
        Canvas(modifier = Modifier.size(180.dp)) {
          // Adjust based on progress percentage
            drawArc(
                color = Color(0xFFAB47BC), // Purple
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 16f, cap = StrokeCap.Round)
            )
        }

        // Text in the center
        Text(
            text = "SET GOAL!",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center)
        )

        // Outer Progress Circle Dot
        Canvas(modifier = Modifier.size(200.dp)) {
            val dotPositionAngle = (sweepAngle - 90f) // Adjust based on progress
            val radius = size.minDimension / 2
            val centerX = center.x + radius * kotlin.math.cos(Math.toRadians(dotPositionAngle.toDouble())).toFloat()
            val centerY = center.y + radius * kotlin.math.sin(Math.toRadians(dotPositionAngle.toDouble())).toFloat()
            drawCircle(
                color = Color(0xFFFF9800), // Orange dot
                radius = 8f,
                center = androidx.compose.ui.geometry.Offset(centerX, centerY)
            )
        }

        // Inner Progress Circle Dot
        Canvas(modifier = Modifier.size(180.dp)) {
            val dotPositionAngle = (sweepAngle - 90f) // Adjust based on progress
            val radius = size.minDimension / 2
            val centerX = center.x + radius * kotlin.math.cos(Math.toRadians(dotPositionAngle.toDouble())).toFloat()
            val centerY = center.y + radius * kotlin.math.sin(Math.toRadians(dotPositionAngle.toDouble())).toFloat()
            drawCircle(
                color = Color(0xFF8E24AA), // Purple dot
                radius = 6f,
                center = androidx.compose.ui.geometry.Offset(centerX, centerY)
            )
        }
    }

}