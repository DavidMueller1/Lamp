package com.example.newlamp.uiElements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.smarttoolfactory.slider.*

@Composable
fun VerticalSlider(
    activeColor: Color,
    changeAction: () -> Unit
) {
    var sliderPosition by remember { mutableStateOf(0f) }
    val trackHeight = 64

    ColorfulIconSlider(
        value = sliderPosition,
        onValueChange = { value, offset -> sliderPosition = value },
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
//            .height(50.dp),


    ) {
        Text(
            text = ""
        )
    }

//    return sliderPosition.roundToInt()
}

@Preview
@Composable
fun SliderPreview() {
    VerticalSlider(activeColor = Color.Red) {

    }
}