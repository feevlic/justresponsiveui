package com.feevlic.justresponsiveui.login.domain.usecase

import javax.inject.Inject

class SaveEmailUseCase @Inject constructor() {
    operator fun saveEmail(email: String): String {
        return email.trim()
    }
}