package com.example.kokos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, currentRoute = currentRoute)
        }
    ) { padding ->
        ProfileContent(modifier = Modifier.padding(padding))
    }
}


@Composable
fun ProfileContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Judul "Profil"
        Text(
            text = "Profil",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Gambar profil
        Image(
            painter = painterResource(id = R.drawable.pp), // Ganti dengan resource gambar profil Anda
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Input field untuk nama, email, dll.
        ProfileTextField(label = "Nama", value = "Creator 09")
        ProfileTextField(label = "Email", value = "Creator09@gmail.com")
        ProfileTextField(label = "No. Hp", value = "090909090909")
        ProfileTextField(label = "Status", value = "Mahasiswa")

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol Simpan
        Button(
            onClick = { /* Handle Save Action */ },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD7B1A7)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Edit",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ProfileTextField(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        TextField(
            value = value,
            onValueChange = {},
            enabled = false, // Membuat TextField read-only
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Gray,
            ),
            singleLine = true
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
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



@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    // Buat navController menggunakan rememberNavController untuk preview
    val navController = rememberNavController()

    // Panggil ProfileScreen dengan navController yang valid
    ProfileScreen(navController = navController)
}



