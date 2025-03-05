package com.example.firebaseauth.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauth.presentation.navigation.AppNavGraph
import com.example.firebaseauth.ui.theme.FirebaseAuthTheme

@Composable
fun AuthApp() {
    val navController = rememberNavController()
    FirebaseAuthTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AppNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}