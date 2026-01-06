package com.feevlic.justresponsiveui.login.domain.usecase

import javax.inject.Inject

class SavePasswordUseCase @Inject constructor() {
    fun savePassword(password: String): String {
        return password
    }
}