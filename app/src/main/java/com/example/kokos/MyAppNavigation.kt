package com.example.kokos

import SettingsScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kokos.pages.HomePage
import com.example.kokos.pages.LoginPage
import com.example.kokos.pages.OptionLoginPage
import com.example.kokos.pages.SignUpPage

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginPage(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable("optionLogin") {
            OptionLoginPage(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable("signUp") {
            SignUpPage(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable("home") {
            HomePage(
                navController = navController,
                modifier = modifier,
                authViewModel = authViewModel
            )
        }
        composable("profile") {
            ProfileScreen(
                navController = navController
            )
        }
        composable("settings") {
            SettingsScreen(
                navController = navController,
                onLogOutClick = {
                    authViewModel.signout()
                    navController.navigate("login") {
                        popUpTo("settings") { inclusive = true }
                    }
                }
            )
        }
    }
}
