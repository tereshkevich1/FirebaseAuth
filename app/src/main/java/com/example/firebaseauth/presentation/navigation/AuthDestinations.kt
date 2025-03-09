package com.example.firebaseauth.presentation.navigation

import kotlinx.serialization.Serializable

sealed class AuthDestinations {
    @Serializable
    data object AuthNav : AuthDestinations()

    @Serializable
    data object CountryCodeSelectionScreen : AuthDestinations()

    @Serializable
    data object PhoneInputScreen : AuthDestinations()

    @Serializable
    data object OtpVerificationScreen : AuthDestinations()

    @Serializable
    data object FinishScreen: AuthDestinations()
}