package com.example.firebaseauth.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AuthDestinations.AuthNav,
        enterTransition = { enterSlideTransition() },
        exitTransition = { exitSlideTransition() },
        popEnterTransition = { popEnterSlideTransition() },
        popExitTransition = { popExitSlideTransition() },
        modifier = modifier
    ) {
        addAuthRoute(navController)
    }
}



