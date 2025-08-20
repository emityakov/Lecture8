package com.example.lecture8.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lecture8.usecase.ValidateCounterValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel(
    private val validateCounterValue: ValidateCounterValue
) : ViewModel() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun increment() {
        val newValue = count.value + 1
        val result = validateCounterValue(newValue)
        if (result.successful) {
            _count.value = newValue
            _error.value = null
        } else {
            _error.value = result.errorMessage
        }
    }

    fun decrement() {
        val newValue = count.value - 1
        val result = validateCounterValue(newValue)
        if (result.successful) {
            _count.value = newValue
            _error.value = null
        } else {
            _error.value = result.errorMessage
        }
    }
}
