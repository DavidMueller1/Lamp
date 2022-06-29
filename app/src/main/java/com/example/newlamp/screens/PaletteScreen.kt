package com.example.newlamp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.newlamp.services.LEDServerService
import com.example.newlamp.ui.theme.*
import com.example.newlamp.uiElements.VerticalSlider
import kotlin.math.roundToInt

@Composable
fun PaletteScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Slider
        Row(
            modifier = Modifier.align(Alignment.Center)
        ) {
            var red = 0; var green = 0; var blue = 0
            VerticalSlider("R", LedRed){
                red = it
                LEDServerService.postRGB(red, green, blue)
            }
            VerticalSlider("G", LedGreen){
                green = it
                LEDServerService.postRGB(red, green, blue)
            }
            VerticalSlider("B", LedBlue){
                blue = it
                LEDServerService.postRGB(red, green, blue)
            }
        }
        // Button new preset
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(DarkButton)
                .align(Alignment.BottomCenter)
                .clickable(true, onClick = {
                    Log.d("DEBUG", "Clicked")
                })
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "plus",
                    tint = Teal200,
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
                Text(
                    text = "Neues Preset".uppercase(),
                    color = Teal200
                )
            }
        }
    }
}

@Preview
@Composable
fun PalettePreview() {
    PaletteScreen(navController = rememberNavController())
}