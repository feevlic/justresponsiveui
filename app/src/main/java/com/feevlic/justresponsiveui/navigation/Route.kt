package com.feevlic.justresponsiveui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Route : NavKey {

    @Serializable
    data object Auth : Route, NavKey {
        @Serializable
        data object Login : Route, NavKey

        @Serializable
        data object Register : Route, NavKey
    }
}