package com.example.newlamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newlamp.bottomNavigation.BottomNavigation
import com.example.newlamp.bottomNavigation.NavigationGraph
import com.example.newlamp.screens.Conversation
import com.example.newlamp.ui.theme.NewLampTheme
import com.example.newlamp.ui.theme.SampleData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewLampTheme {
                MainScreenView()
            }
        }
    }
}

@Preview
@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) },
    ) {
        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            NavigationGraph(navController = navController)
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "chat") {
        composable("chat") { Conversation(navController = navController, messages = SampleData.conversationSample)}
    }
}