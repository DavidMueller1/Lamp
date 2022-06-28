package com.example.newlamp.bottomNavigation

import com.example.newlamp.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String) {
    object Palette : BottomNavItem("Palette", R.drawable.ic_controls,"palette")
    object Presets : BottomNavItem("Presets", R.drawable.ic_list,"presets")
    object Special : BottomNavItem("Special", R.drawable.ic_star,"special")
}