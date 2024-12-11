package com.example.kokos.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kokos.AuthViewModel
import com.example.kokos.R
import com.example.kokos.ui.theme.Primary

@Composable
fun OptionLoginPage(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Masuk Sebagai?",
            style = MaterialTheme.typography.headlineLarge.copy(),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5C3537)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OptionButton(
            text = "Pencari Kos",
            icon = painterResource(id = R.drawable.outline_supervised_user_circle_24),
            onClick = {
                navController.navigate("login")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OptionButton(
            text = "Pemilik Kos",
            icon = painterResource(id = R.drawable.outline_supervised_user_circle_24),
            onClick = {
                navController.navigate("login")
            }
        )
    }
}

@Composable
fun OptionButton(text: String, icon: Painter, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary,
        ),
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(48.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = text, fontWeight = FontWeight.Bold)
        }
    }
}