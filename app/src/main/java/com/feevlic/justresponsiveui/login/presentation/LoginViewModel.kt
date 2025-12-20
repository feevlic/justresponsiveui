package com.feevlic.justresponsiveui.login.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.feevlic.justresponsiveui.login.domain.usecase.SaveEmailUseCase
import com.feevlic.justresponsiveui.login.domain.usecase.SavePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val emailUseCase: SaveEmailUseCase,
    private val passwordUseCase: SavePasswordUseCase
) : ViewModel() {
    companion object {
        private const val KEY_EMAIL = "login_email"
        private const val KEY_PASSWORD = "login_password"
    }

    val email: StateFlow<String> = savedStateHandle.getStateFlow(KEY_EMAIL, "")
    val password: StateFlow<String> = savedStateHandle.getStateFlow(KEY_PASSWORD, "")

    fun onEmailChanged(newValue: String) {
        savedStateHandle[KEY_EMAIL] = emailUseCase.invoke(newValue)
    }

    fun onPasswordChanged(newValue: String) {
        savedStateHandle[KEY_PASSWORD] = passwordUseCase.invoke(newValue)
    }
}