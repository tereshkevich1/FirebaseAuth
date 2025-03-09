package com.example.firebaseauth.presentation.navigation.destinations

import kotlinx.serialization.Serializable

sealed class SplashDestinations {
    @Serializable
    data object SplashNav : SplashDestinations()

    @Serializable
    data object SplashScreen : SplashDestinations()
}