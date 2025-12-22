package com.feevlic.justresponsiveui.login.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.feevlic.justresponsiveui.login.domain.usecase.SaveEmailUseCase
import com.feevlic.justresponsiveui.login.domain.usecase.SavePasswordUseCase
import com.feevlic.justresponsiveui.login.domain.usecase.ValidateEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val emailUseCase: SaveEmailUseCase,
    private val passwordUseCase: SavePasswordUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase
) : ViewModel() {
    companion object {
        private const val KEY_EMAIL = "login_email"
        private const val KEY_PASSWORD = "login_password"
        private const val KEY_EMAIL_ERROR = "login_email_error"
    }

    val email: StateFlow<String> = savedStateHandle.getStateFlow(KEY_EMAIL, "")
    val password: StateFlow<String> = savedStateHandle.getStateFlow(KEY_PASSWORD, "")
    val emailError: StateFlow<Boolean> = savedStateHandle.getStateFlow(KEY_EMAIL_ERROR, false)

    fun onEmailChanged(newValue: String) {
        val cleaned = emailUseCase.saveEmail(newValue)
        savedStateHandle[KEY_EMAIL] = cleaned
        if (cleaned.isBlank()) {
            savedStateHandle[KEY_EMAIL_ERROR] = false
        }
    }

    fun onPasswordChanged(newValue: String) {
        savedStateHandle[KEY_PASSWORD] = passwordUseCase.savePassword(newValue)
    }

    fun onLoginClicked() {
        val currentEmail = savedStateHandle.get<String>(KEY_EMAIL) ?: ""
        val isValid = validateEmailUseCase.validateEmail(currentEmail)
        savedStateHandle[KEY_EMAIL_ERROR] = !isValid
    }
}