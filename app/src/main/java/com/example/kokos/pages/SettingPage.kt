import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kokos.R

@Composable
fun SettingsScreen(navController: NavController, onLogOutClick: () -> Unit) {
    // Mendapatkan rute saat ini dari navController
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTitle(title = "Pengaturan")
        Spacer(modifier = Modifier.height(16.dp))

        // Menu Buttons
        SettingsButton(text = "Pusat Bantuan", onClick = { /* Handle Help Center */ })
        SettingsButton(text = "Kebijakan Privasi", onClick = { /* Handle Privacy Policy */ })
        SettingsButton(text = "Kontak Kami", onClick = { /* Handle Contact Us */ })

        Spacer(modifier = Modifier.height(24.dp))

        // Logout Button
        LogOutButton(onLogOutClick = onLogOutClick)

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation
        BottomNavigationBar(navController = navController, currentRoute = currentRoute)
    }
}

@Composable
fun HeaderTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
fun SettingsButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(vertical = 8.dp)
            .background(Color(0xFFEDE7E6), RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center) // Ensure text is centered inside the Box
        )
    }
}

@Composable
fun LogOutButton(onLogOutClick: () -> Unit) {
    Button(
        onClick = onLogOutClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBFA3A3)),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .defaultMinSize(minWidth = 100.dp)
            .padding(vertical = 12.dp) // Add vertical padding for better appearance
    ) {
        Text(text = "Log Out", color = Color.White, fontWeight = FontWeight.Bold)
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


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController(), onLogOutClick = {})
}
