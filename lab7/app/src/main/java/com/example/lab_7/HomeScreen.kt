package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FormulaZero Home",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // go to races
        Button(
            onClick = { navController.navigate("races") },
            modifier = Modifier.testTag("raceButton")
        ) {
            Text("Upcoming Races")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // go to drivers
        Button(
            onClick = { navController.navigate("drivers") },
            modifier = Modifier.testTag("driversButton")
        ) {
            Text("FormulaZero Drivers")
        }
    }
}