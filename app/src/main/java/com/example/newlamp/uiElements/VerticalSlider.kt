package com.example.newlamp.uiElements

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.slider.*

@Composable
fun VerticalSlider(
    label: String,
    activeColor: Color,
    changeAction: (Int) -> Unit
) {
    var sliderPosition by remember { mutableStateOf(0f) }
    val trackHeight = 64
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        ColorfulIconSlider(
            value = sliderPosition,
            onValueChange = { value, _ -> sliderPosition = value },
            onValueChangeFinished = { changeAction((sliderPosition * 256).toInt()) },
            valueRange = 0f..1f,
            trackHeight = trackHeight.dp,
            colors = MaterialSliderDefaults.defaultColors(
                thumbColor = SliderBrushColor(color = Color.Transparent),
                disabledThumbColor = SliderBrushColor(color = Color.Transparent),
                activeTrackColor = SliderBrushColor(activeColor),
            ),
            modifier = Modifier
                .graphicsLayer {
                    rotationZ = 270f
                    transformOrigin = TransformOrigin(0f, 0f)
                }
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(
                        Constraints(
                            minWidth = constraints.minHeight,
                            maxWidth = constraints.maxHeight,
                            minHeight = constraints.minWidth,
                            maxHeight = constraints.maxHeight,
                        )
                    )
                    layout(placeable.height, placeable.width) {
                        placeable.place(-placeable.width, 0)
                    }
                }
                .width(300.dp),


        ) { Text(text = "") }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = label,
            color = activeColor,
            fontSize = 30.sp
        )
    }
}

@Preview
@Composable
fun SliderPreview() {
    VerticalSlider("R", activeColor = Color.Red) {

    }
}