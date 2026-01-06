package com.feevlic.justresponsiveui.auth.register.domain

import javax.inject.Inject

class SaveNameUseCase @Inject constructor() {
    fun saveName(name: String): String {
        return name.trim()
    }
}