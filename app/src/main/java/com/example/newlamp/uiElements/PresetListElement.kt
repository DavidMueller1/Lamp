package com.example.newlamp.uiElements

import android.content.res.ColorStateList
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlamp.R
import androidx.navigation.compose.rememberNavController
import com.example.newlamp.models.ColorPreset
import com.example.newlamp.screens.PresetsScreen
import com.example.newlamp.services.LEDServerService
import com.example.newlamp.ui.theme.ColorFontDark
import com.example.newlamp.ui.theme.ColorFontLight

@Composable
fun PresetListElement(colorPreset: ColorPreset) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .background(Color(colorPreset.red, colorPreset.green, colorPreset.blue, 255))
                .clickable {
                    LEDServerService.postRGB(
                        colorPreset.red,
                        colorPreset.green,
                        colorPreset.blue,
                    )
                }
        ) {
            val foregroundColor = calculateTextColor(colorPreset.red, colorPreset.green, colorPreset.blue)
            Text(
                text = colorPreset.title?.uppercase().orEmpty(),
                color = foregroundColor,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp)
            )

            Icon(
                painterResource(id = R.drawable.ic_trash),
                contentDescription = "trash",
                tint = foregroundColor,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.CenterEnd)
                    .size(24.dp)
                    .clickable {
                        Log.d("DEBUG", "Trashed")
                    }
            )
        }
    }
}

private fun calculateTextColor(red: Int, green: Int, blue: Int): Color {
    val hsv = FloatArray(3)
    val presetColor = android.graphics.Color.rgb(red, green, blue)
    android.graphics.Color.colorToHSV(presetColor, hsv)

    return if (hsv[2] < 0.75f) ColorFontLight else ColorFontDark
}

@Preview
@Composable
fun PresetListElementPreview() {
    PresetListElement(colorPreset = ColorPreset("Test", 40, 30, 20))
}