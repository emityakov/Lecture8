package com.example.lecture8.usecase

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)

class ValidateCounterValue {
    operator fun invoke(value: Int): ValidationResult {
        if (value < 0) {
            return ValidationResult(false, "Значение не может быть отрицательным")
        }
        if (value > 100) {
            return ValidationResult(false, "Значение не может быть больше 100")
        }
        return ValidationResult(true)
    }
}
