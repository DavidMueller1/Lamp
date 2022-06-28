package com.example.newlamp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newlamp.R
import com.example.newlamp.ui.theme.DarkButton
import com.example.newlamp.ui.theme.NewLampTheme
import com.example.newlamp.ui.theme.Purple200
import com.example.newlamp.ui.theme.Teal200

@Composable
fun PaletteScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
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