package com.example.kokos.pages

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kokos.AuthState
import com.example.kokos.AuthViewModel
import com.example.kokos.ui.theme.Primary

@Composable
fun SignUpPage(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var  nama by remember {
        mutableStateOf("")
    }

    var konfirmasiPassword by remember {
        mutableStateOf("")
    }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(bottomEnd = 100.dp, bottomStart = 100.dp))
                .background(Color(0xFFBDA2A2))
        ) {

        }

        Column(
            Modifier
                .padding(24.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "MASUK",
                color = Color(0xFFBDA2A2),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                shape = RoundedCornerShape(25.dp),
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text(text = "Email") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = "Email Icon",
                        tint = Color(0xFFBDA2A2)
                    ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
                    .border(
                        width = 3.dp,
                        color = Color(0xFFBDA2A2),
                        shape = RoundedCornerShape(25.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color(0xFFBBBBBB)
                )
            )


            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                shape = RoundedCornerShape(25.dp),
                value = nama,
                onValueChange = {
                    nama = it
                },
                label = { Text(text = "Nama") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Create,
                        contentDescription = "Create Icon",
                        tint = Color(0xFFBDA2A2)
                    ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
                    .border(
                        width = 3.dp,
                        color = Color(0xFFBDA2A2),
                        shape = RoundedCornerShape(25.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color(0xFFBBBBBB)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                shape = RoundedCornerShape(25.dp),
                value = password,
                onValueChange = {
                    password = it
                },
                label = { Text(text = "Password") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Lock,
                        contentDescription = "Lock Icon",
                        tint = Color(0xFFBDA2A2)
                    ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
                    .border(
                        width = 3.dp,
                        color = Color(0xFFBDA2A2),
                        shape = RoundedCornerShape(25.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color(0xFFBBBBBB)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                shape = RoundedCornerShape(25.dp),
                value = konfirmasiPassword,
                onValueChange = {
                    konfirmasiPassword = it
                },
                label = { Text(text = "Konfirmasi Password") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Lock,
                        contentDescription = "Lock Icon",
                        tint = Color(0xFFBDA2A2)
                    ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
                    .border(
                        width = 3.dp,
                        color = Color(0xFFBDA2A2),
                        shape = RoundedCornerShape(25.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color(0xFFBBBBBB)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFAE9A9B)
                ),
                contentPadding = ButtonDefaults.ContentPadding,
                onClick = {
                    authViewModel.signup(email, password)
                }
            ) {
                Text(text = "DAFTAR")
            }

            TextButton(
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Primary
                ),
                onClick = {
                    navController.navigate("login")
                }
            ) {
                Text(text = "Sudah punya akun? Langsung masuk")
            }
        }
    }
}