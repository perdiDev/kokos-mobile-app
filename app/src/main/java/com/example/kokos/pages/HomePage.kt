package com.example.kokos.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kokos.AuthState
import com.example.kokos.AuthViewModel
import com.example.kokos.NavigationIcon
import com.example.kokos.ProfileContent
import com.example.kokos.R

@Composable
fun HomePage(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val authState = authViewModel.authState.observeAsState()

    // Menangani perubahan status autentikasi dan navigasi ke login jika perlu
    LaunchedEffect(authState.value) {
        if (authState.value is AuthState.Unauthenticated) {
            navController.navigate("login") {
                // Menghapus backstack agar pengguna tidak bisa kembali ke halaman sebelumnya
                popUpTo("home") { inclusive = true }
            }
        }
    }

    // Scaffold dengan BottomNavigationBar yang sesuai
    Scaffold(
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
            BottomNavigationBar(navController = navController, currentRoute = currentRoute)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Home Page")

            // Button Logout
            Button(onClick = {
                authViewModel.signout()
                navController.navigate("login") {
                    // Menghapus backstack setelah logout
                    popUpTo("home") { inclusive = true }
                }
            }) {
                Text(text = "Logout")
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, currentRoute: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD7B1A7))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NavigationIcon(
            resourceId = R.drawable.ic_home,
            contentDescription = "Home",
            onClick = { navController.navigate("home") },
            isSelected = currentRoute == "home"
        )
        NavigationIcon(
            resourceId = R.drawable.ic_favorite,
            contentDescription = "Favorites",
            onClick = { navController.navigate("favorites") },
            isSelected = currentRoute == "favorites"
        )
        NavigationIcon(
            resourceId = R.drawable.ic_profile,
            contentDescription = "Profile",
            onClick = { navController.navigate("profile") },
            isSelected = currentRoute == "profile"
        )
        NavigationIcon(
            resourceId = R.drawable.ic_settings,
            contentDescription = "Settings",
            onClick = { navController.navigate("settings") },
            isSelected = currentRoute == "settings"
        )
    }
}

@Composable
fun NavigationIcon(resourceId: Int, contentDescription: String, onClick: () -> Unit, isSelected: Boolean = false) {
    Icon(
        painter = painterResource(id = resourceId),
        contentDescription = contentDescription,
        tint = if (isSelected) Color.White else Color.Gray, // Menandai ikon yang terpilih
        modifier = Modifier
            .size(24.dp)
            .clickable(onClick = onClick)
    )
}
