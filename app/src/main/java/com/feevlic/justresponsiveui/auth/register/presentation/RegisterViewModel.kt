package com.feevlic.justresponsiveui.auth.register.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.feevlic.justresponsiveui.auth.register.domain.SaveNameUseCase
import com.feevlic.justresponsiveui.auth.shared.domain.usecase.ValidateEmailUseCase
import com.feevlic.justresponsiveui.auth.shared.domain.usecase.ValidatePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val saveNameUseCase: SaveNameUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
) : ViewModel() {

    companion object {
        private const val KEY_NAME = "register_name"
        private const val KEY_EMAIL = "register_email"
        private const val KEY_PASSWORD = "register_password"
        private const val KEY_EMAIL_ERROR = "register_email_error"
        private const val KEY_PASSWORD_ERROR = "register_password_error"
    }

    private val _name: StateFlow<String> = savedStateHandle.getStateFlow(KEY_NAME, "")
    val name: StateFlow<String> = _name

    private val _email: StateFlow<String> = savedStateHandle.getStateFlow(KEY_EMAIL, "")
    val email: StateFlow<String> = _email

    private val _password: StateFlow<String> = savedStateHandle.getStateFlow(KEY_PASSWORD, "")
    val password: StateFlow<String> = _password

    private val _emailError: StateFlow<Boolean> =
        savedStateHandle.getStateFlow(KEY_EMAIL_ERROR, false)
    val emailError: StateFlow<Boolean> = _emailError

    private val _passwordError: StateFlow<Boolean> =
        savedStateHandle.getStateFlow(KEY_PASSWORD_ERROR, false)
    val passwordError: StateFlow<Boolean> = _passwordError

    fun setEmail(value: String) {
        savedStateHandle[KEY_EMAIL] = value.trim()
    }

    fun onNameChanged(newValue: String) {
        val cleaned = saveNameUseCase.saveName(newValue)
        savedStateHandle[KEY_NAME] = cleaned
    }

    fun onEmailChanged(newValue: String) {
        savedStateHandle[KEY_EMAIL] = newValue.trim()
        if (newValue.trim().isBlank()) {
            savedStateHandle[KEY_EMAIL_ERROR] = false
        }
    }

    fun onPasswordChanged(newValue: String) {
        savedStateHandle[KEY_PASSWORD] = newValue
        if (newValue.isBlank()) {
            savedStateHandle[KEY_PASSWORD_ERROR] = false
        }
    }

    fun onSignupClicked() {
        val currentEmail = savedStateHandle.get<String>(KEY_EMAIL) ?: ""
        val currentPassword = savedStateHandle.get<String>(KEY_PASSWORD) ?: ""

        val isEmailValid = validateEmailUseCase.validateEmail(currentEmail)
        val isPasswordValid = validatePasswordUseCase.validatePassword(currentPassword)

        savedStateHandle[KEY_EMAIL_ERROR] = !isEmailValid
        savedStateHandle[KEY_PASSWORD_ERROR] = !isPasswordValid
    }
}