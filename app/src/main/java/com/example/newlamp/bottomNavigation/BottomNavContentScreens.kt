package com.example.newlamp.bottomNavigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.newlamp.screens.PaletteScreen

@Composable
fun PagePaletteScreen(navController: NavController) {
    PaletteScreen(navController = navController)
}

@Composable
fun PagePresetsScreen(navController: NavController) {
//    PaletteScreen(navController = navController)
    Text(
        text = "Presets"
    )
}

@Composable
fun PageSpecialScreen(navController: NavController) {
//    PaletteScreen(navController = navController)
    Text(
        text = "Special"
    )
}