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
        enterTransition = { enterFadeTransaction() },
        exitTransition = { exitFadeTransaction() },
        popEnterTransition = { enterFadeTransaction() },
        popExitTransition = { exitFadeTransaction() },
        modifier = modifier
    ) {
        addAuthRoute(navController)
    }
}



