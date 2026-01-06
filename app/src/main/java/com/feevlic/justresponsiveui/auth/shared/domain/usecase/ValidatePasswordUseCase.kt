package com.feevlic.justresponsiveui.auth.shared.domain.usecase

import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {
    private val MIN_LENGTH = 8
    private val UPPER_REGEX = Regex("[A-Z]")
    private val DIGIT_REGEX = Regex("\\d")

    fun validatePassword(password: String): Boolean {
        val password = password.trim()
        if (password.length < MIN_LENGTH) return false
        if (!UPPER_REGEX.containsMatchIn(password)) return false
        if (!DIGIT_REGEX.containsMatchIn(password)) return false
        return true
    }
}