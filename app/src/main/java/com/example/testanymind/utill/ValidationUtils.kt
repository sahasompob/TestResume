package com.example.testanymind.utill

object ValidationUtils {

    fun validationString(value: String, textError: String): String {
        return when {
            value.isEmpty() -> textError
            else -> ""
        }
    }
}