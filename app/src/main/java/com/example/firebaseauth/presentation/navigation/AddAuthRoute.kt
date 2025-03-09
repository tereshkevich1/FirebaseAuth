package com.example.firebaseauth.presentation.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.firebaseauth.presentation.country_code_selection_screen.CountryCodeSelectionScreen
import com.example.firebaseauth.presentation.finish_screen.FinishScreen
import com.example.firebaseauth.presentation.login_screen.PhoneNumberInputScreen
import com.example.firebaseauth.presentation.otp_verification_screen.OtpVerificationScreen

fun NavGraphBuilder.addAuthRoute(navController: NavController) {
    navigation<AuthDestinations.AuthNav>(startDestination = AuthDestinations.PhoneInputScreen) {
        phoneInputDestination(navController)
        countryCodeSelectionDestination(navController)
        otpVerificationDestination(navController)
        finishScreenDestination()
    }
}

fun NavGraphBuilder.countryCodeSelectionDestination(navController: NavController) {
    composable<AuthDestinations.CountryCodeSelectionScreen> {
        val parentEntry = remember { navController.getBackStackEntry(AuthDestinations.AuthNav) }
        CountryCodeSelectionScreen(
            onBack = { navController.popBackStack() },
            onSelect = { navController.popBackStack() },
            countryCodeViewModel = hiltViewModel(parentEntry),
            phoneNumberViewModel = hiltViewModel(parentEntry)
        )
    }
}

fun NavGraphBuilder.otpVerificationDestination(navController: NavController) {
    composable<AuthDestinations.OtpVerificationScreen> {
        val parentEntry = remember { navController.getBackStackEntry(AuthDestinations.AuthNav) }
        OtpVerificationScreen(
            onBack = { navController.popBackStack() },
            onVerificationSuccess = { navController.navigate(AuthDestinations.FinishScreen) },
            authViewModel = hiltViewModel(parentEntry),
            phoneNumberViewModel = hiltViewModel(parentEntry),
            countryCodeViewModel = hiltViewModel(parentEntry)
        )
    }
}

fun NavGraphBuilder.phoneInputDestination(navController: NavController) {
    composable<AuthDestinations.PhoneInputScreen> {
        val parentEntry = remember { navController.getBackStackEntry(AuthDestinations.AuthNav) }
        PhoneNumberInputScreen(
            onCountryCodeButtonClick = { navController.navigate(AuthDestinations.CountryCodeSelectionScreen) },
            onContinueButtonClick = { navController.navigate(AuthDestinations.OtpVerificationScreen) },
            countryCodeViewModel = hiltViewModel(parentEntry),
            phoneNumberViewModel = hiltViewModel(parentEntry),
            authViewModel = hiltViewModel(parentEntry)
        )
    }
}

fun NavGraphBuilder.finishScreenDestination() {
    composable<AuthDestinations.FinishScreen> {
        FinishScreen()
    }
}

