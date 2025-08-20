package com.example.lecture8.ui.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lecture8.usecase.ValidateCounterValue
import com.example.lecture8.viewmodel.CounterViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: CounterViewModel

    @Before
    fun setUp() {
        viewModel = CounterViewModel(ValidateCounterValue())
    }

    @Test
    fun clickingIncrementButton_increasesCounterText() {
        composeTestRule.setContent {
            CounterScreen(viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("Счёт: 1").assertExists()
    }

    @Test
    fun clickingDecrementBelowZero_showsErrorMessage() {
        composeTestRule.setContent {
            CounterScreen(viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("−").performClick()
        composeTestRule.onNodeWithText("Значение не может быть отрицательным").assertExists()
    }
}