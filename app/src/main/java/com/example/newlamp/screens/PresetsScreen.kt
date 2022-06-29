package com.example.newlamp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newlamp.R
import com.example.newlamp.models.ColorPreset
import com.example.newlamp.services.LEDServerService
import com.example.newlamp.ui.theme.*
import com.example.newlamp.uiElements.PresetListElement
import com.example.newlamp.uiElements.VerticalSlider
import kotlin.math.roundToInt

@Composable
fun PresetsScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        val testPresets = listOf(
            ColorPreset("Red", 100, 0, 0),
            ColorPreset("Green", 0, 100, 0),
            ColorPreset("Blue", 100, 100, 200),
        )

        items(testPresets) { colorPreset ->
            PresetListElement(colorPreset = colorPreset)
        }
    }
}

@Preview
@Composable
fun PresetsPreview() {
    PresetsScreen(navController = rememberNavController())
}