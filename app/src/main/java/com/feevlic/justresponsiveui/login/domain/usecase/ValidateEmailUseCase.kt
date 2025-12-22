package com.feevlic.justresponsiveui.login.domain.usecase

import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor() {
    private val EMAIL_REGEX = Regex("""[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}""")

    operator fun validateEmail(email: String): Boolean {
        return EMAIL_REGEX.matches(email.trim())
    }
}