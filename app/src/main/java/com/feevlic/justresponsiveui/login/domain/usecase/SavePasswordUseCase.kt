package com.feevlic.justresponsiveui.login.domain.usecase

import javax.inject.Inject

class SavePasswordUseCase @Inject constructor() {
    operator fun invoke(password: String): String {
        return password
    }
}