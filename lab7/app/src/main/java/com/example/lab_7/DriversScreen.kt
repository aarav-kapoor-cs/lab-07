package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.padding(16.dp)) {

        Spacer(modifier = Modifier.height(16.dp))

        // back button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.testTag("backButton")
        ) {
            Text("Back")
        }

        // title
        Text("FormulaZero Drivers")

        // type a driver name
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Driver Name") },
            modifier = Modifier.testTag("driverInput")
        )

        // add driver
        Button(
            onClick = {
                if (name.isNotBlank()) {
                    drivers.add(name)
                    name = ""
                }
            },
            modifier = Modifier.testTag("addDriverButton")
        ) {
            Text("Add")
        }

        // clear all drivers
        Button(
            onClick = { drivers.clear() },
            modifier = Modifier.testTag("clearButton")
        ) {
            Text("Clear")
        }

        // list of drivers
        LazyColumn {
            items(drivers) { driver ->
                Text(driver)
            }
        }
    }
}