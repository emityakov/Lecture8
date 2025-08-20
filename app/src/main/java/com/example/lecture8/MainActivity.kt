package com.example.lecture8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lecture8.ui.MyAppTheme
import com.example.lecture8.ui.screens.CounterScreen
import com.example.lecture8.usecase.ValidateCounterValue
import com.example.lecture8.viewmodel.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val validateCounterValue = ValidateCounterValue()
        val viewModel = CounterViewModel(validateCounterValue)

        setContent {
            MyAppTheme {
                CounterScreen(viewModel = viewModel)
            }
        }
    }
}
