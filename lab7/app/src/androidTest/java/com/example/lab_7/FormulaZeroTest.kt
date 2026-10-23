package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // walkthrough test
    @Test
    fun navigate_to_races_add_race_and_return_home() {
        composeTestRule.onNodeWithTag("raceButton").performClick()
        composeTestRule.onNodeWithText("Upcoming Races").assertExists()

        composeTestRule.onNodeWithTag("locationInput").performTextInput("Canada")
        composeTestRule.onNodeWithTag("addRaceButton").performClick()
        composeTestRule.onNodeWithText("Canada").assertExists()

        composeTestRule.onNodeWithTag("backButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertExists()
    }

    // participation exercise test
    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // 1. go to drivers screen
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Drivers").assertExists()

        // 2. add a driver
        composeTestRule.onNodeWithTag("driverInput").performTextInput("Max")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Max").assertExists()

        // 3. clear the list
        composeTestRule.onNodeWithTag("clearButton").performClick()
        composeTestRule.onNodeWithText("Max").assertDoesNotExist()

        // 4. go back home
        composeTestRule.onNodeWithTag("backButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertExists()
    }
}