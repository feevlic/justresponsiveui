package com.feevlic.justresponsiveui.login.domain.usecase

import javax.inject.Inject

class SaveEmailUseCase @Inject constructor() {
    operator fun invoke(email: String): String {
        return email.trim()
    }
}