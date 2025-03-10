package com.example.firebaseauth.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.firebaseauth.presentation.navigation.destinations.AuthDestinations
import com.example.firebaseauth.presentation.navigation.destinations.SplashDestinations
import com.example.firebaseauth.presentation.splash_screen.SplashScreen

fun NavGraphBuilder.addSplashRoute(navController: NavController) {
    navigation<SplashDestinations.SplashNav>(startDestination = SplashDestinations.SplashScreen) {
        splashScreenDestination(navController)
    }
}

fun NavGraphBuilder.splashScreenDestination(navController: NavController) {
    composable<SplashDestinations.SplashScreen> {
        SplashScreen(onSplashFinished = {
            navController.navigate(AuthDestinations.AuthNav) {
                popUpTo<SplashDestinations.SplashScreen> {
                    inclusive = true
                }
            }
        })
    }
}