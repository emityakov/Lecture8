package com.example.lecture8.usecase

import org.junit.Test
import org.junit.Assert.*

class ValidateCounterValueTest {

    private val validator = ValidateCounterValue()

    @Test
    fun whenValueIsNegative_thenReturnsError() {
        val result = validator(-5)
        assertFalse(result.successful)
        assertEquals("Значение не может быть отрицательным", result.errorMessage)
    }

    @Test
    fun whenValueIsOver100_thenReturnsError() {
        val result = validator(150)
        assertFalse(result.successful)
        assertEquals("Значение не может быть больше 100", result.errorMessage)
    }

    @Test
    fun whenValueIsValid_thenReturnsSuccess() {
        val result = validator(50)
        assertTrue(result.successful)
        assertNull(result.errorMessage)
    }
}