package com.feevlic.justresponsiveui.auth.shared.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.feevlic.justresponsiveui.auth.login.presentation.LoginScreen
import com.feevlic.justresponsiveui.auth.register.presentation.RegisterScreen
import com.feevlic.justresponsiveui.auth.shared.presentation.SharedAuthViewModel
import com.feevlic.justresponsiveui.navigation.Route
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun AuthNavigation(modifier: Modifier = Modifier, onLogin: () -> Unit) {
    val authBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.Auth.Login::class, Route.Auth.Login.serializer())
                    subclass(Route.Auth.Register::class, Route.Auth.Register.serializer())
                }
            }
        }, Route.Auth.Login
    )

    val sharedAuthViewModel: SharedAuthViewModel = hiltViewModel()

    NavDisplay(
        backStack = authBackStack, entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), modifier = Modifier, entryProvider = entryProvider {
            entry<Route.Auth.Login> {
                LoginScreen(
                    sharedAuthViewModel = sharedAuthViewModel,
                    onRegister = { authBackStack.add(Route.Auth.Register) })
            }
            entry<Route.Auth.Register> {
                RegisterScreen(sharedAuthViewModel = sharedAuthViewModel)
            }
        })
}