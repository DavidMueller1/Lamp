package com.example.newlamp.bottomNavigation

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newlamp.ui.theme.ColorBottomNavigationBackground
import com.example.newlamp.ui.theme.ColorInactive
import com.example.newlamp.ui.theme.Teal200

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Palette.screen_route) {
        composable(BottomNavItem.Palette.screen_route) {
            PagePaletteScreen(navController)
        }
        composable(BottomNavItem.Presets.screen_route) {
            PagePresetsScreen(navController)
        }
        composable(BottomNavItem.Special.screen_route) {
            PageSpecialScreen(navController)
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Palette,
        BottomNavItem.Presets,
        BottomNavItem.Special
    )

    androidx.compose.material.BottomNavigation(
        backgroundColor = ColorBottomNavigationBackground,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(
                    text = item.title,
                    fontSize = 11.sp
                ) },
                selectedContentColor = Teal200,
                unselectedContentColor = ColorInactive,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigation() {
    BottomNavigation(navController = rememberNavController())
}