package com.example.kokos.pages
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kokos.AuthViewModel
import com.example.kokos.R

@Composable
fun HomePage(
    modifier: Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    Scaffold (
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                currentRoute = currentRoute
            )
        }
    ) {
        padding -> Home(modifier = Modifier.padding(padding), navController)
    }
}

@Composable
fun Home(modifier: Modifier, navController: NavController) {
    Column (
        Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        HeroView()

        Spacer(modifier =Modifier.height(24.dp))

        SectionRekomendasi(navController)

        Spacer(modifier =Modifier.height(24.dp))

        SectionAreaKampus()

        Spacer(modifier =Modifier.height(24.dp))

        SectionKosTerdekat()
    }
}

@Composable
private fun HeroView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_image_kokos1),
            contentDescription = "BG Kos",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
                .clip(
                    RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 25.dp)
                )
                .drawWithContent {
                    val colors = listOf(
                        Color.Black.copy(alpha = 0.3f),
                        Color.Black.copy(alpha = 0.5f)
                    )
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                    )
                }
        )

        Column {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_kokos),
                    contentDescription = "Logo Kokos",
                    modifier = Modifier
                        .height(75.dp)
                        .width(75.dp)
                )

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Text(
                            text = "Keluar",
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notif",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp),
                        tint = Color.White
                    )
                }
            }

            Column (
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Lagi Butuh Kostt ??",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Dapatkan Kost Impian Anda Bersama kami",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp)
            }
        }

    }
}

@Composable
private fun SectionRekomendasi(navController: NavController) {
    Column (
        Modifier.padding(horizontal = 12.dp)
    ) {
        Text(
            text = "Rekomendasi",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium)


        Spacer(modifier = Modifier.height(12.dp))

        LazyRow {
            items(2) {
                Box(
                    Modifier
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .background(
                            Color.Gray.copy(alpha = 0.2f)
                        )
                        .padding(12.dp)
                        .clickable { navController.navigate("detail_kost") }
                ) {
                    Column (
                        Modifier.width(180.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bg_image_kokos1),
                            contentDescription = "Kos resal",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Kost Resal",
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(text = "Rp. 500.000 / bln")
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }

}

@Composable
private fun SectionAreaKampus() {
    Column (
        Modifier.padding(horizontal = 12.dp)
    ) {
        Text(
            text = "Area Kampus",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow (
            modifier = Modifier.padding(vertical = 2.dp)
        ) {
            items(3) {
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(12.dp)
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.unhas),
                            contentDescription = "Logo Unhas",
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Unhas",
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun SectionKosTerdekat() {
    Column (
        Modifier.padding(horizontal = 12.dp)
    ) {
        Text(
            text = "Terdekat",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow {
            items(2) {
                Box(
                    Modifier
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .background(
                            Color.Gray.copy(alpha = 0.2f)
                        )
                        .padding(12.dp)
                ) {
                    Column (
                        Modifier.width(180.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bg_image_kokos1),
                            contentDescription = "Kos resal",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Kost Resal",
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(text = "Rp. 500.000 / bln")
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))
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
