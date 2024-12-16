package com.example.kokos.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kokos.BottomNavigationBar
import com.example.kokos.R

// Data class to represent each Kost Terkait item
data class KostTerkaitData(val name: String, val price: String, val rating: String)

@Composable
fun DetailKostScreen(navController: NavController) { // Menambahkan navController sebagai parameter
    // List of "Kost Terkait" items
    val kostList = listOf(
        KostTerkaitData("Kost Fatih", "Rp. 50.000 / bln", "95%"),
        KostTerkaitData("Kost Budi", "Rp. 70.000 / bln", "92%"),
        KostTerkaitData("Kost Ali", "Rp. 60.000 / bln", "90%")
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController, currentRoute = "detailKost") } // Menyertakan navController
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Tombol kembali dan judul
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "< kembali",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite), // Gunakan nama file lowercase
                    contentDescription = "favorit",
                    tint = Color.Red
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Gambar utama
            Image(
                painter = painterResource(id = R.drawable.gambarkos), // Ganti dengan gambar utama
                contentDescription = "Kost Resal",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.LightGray, RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nama Kost & Harga
            Text(
                text = "Kost Resal",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Rp 150.000.000 / Tahun",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color(0xFF4CAF50)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Alamat Kost
            Text(
                text = "jl. Timun sari asem, Moutong, Kec. Tilongkabila, Kab. Bone Bolango, Gorontalo",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Spesifikasi
            Text(
                text = "Spesifikasi",
                style = TextStyle(fontWeight = FontWeight.SemiBold)
            )
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text("✅ 100 x 110 meter")
                Text("✅ Gratis Listrik")
                Text("✅ Gratis Air")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Fasilitas
            Text(
                text = "Fasilitas",
                style = TextStyle(fontWeight = FontWeight.SemiBold)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("\uD83D\uDECF  Kasur")
                    Text("🌬 AC")
                    Text("🗄 Lemari")
                }
                Column {
                    Text("📶 Wifi")
                    Text("🖥 Meja Belajar")
                    Text("🚪 Kamar mandi dalam")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Informasi Tambahan
            Text(
                text = "Informasi Tambahan",
                style = TextStyle(fontWeight = FontWeight.SemiBold)
            )
            Text(
                text = "Pokoknya Kost Disini Hidup Anda Dijamin Bahagia.",
                style = TextStyle(fontSize = 12.sp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Kost Terkait
            Text(
                text = "Kost Terkait",
                style = TextStyle(fontWeight = FontWeight.SemiBold)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // LazyRow for Kost Terkait
            LazyRow {
                items(kostList) { kost ->
                    KostTerkaitItem(
                        name = kost.name,
                        price = kost.price,
                        rating = kost.rating
                    )
                }
            }
        }
    }
}

@Composable
fun KostTerkaitItem(name: String, price: String, rating: String) {
    Column(
        modifier = Modifier
            .padding(end = 16.dp)
            .width(150.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.gambarkos2), // Gambar Kost
            contentDescription = name,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = price,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Gray
            )
        )
        Text(
            text = rating,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color(0xFF4CAF50)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailKostScreenPreview() {
    // Perbaiki dengan menambahkan navController pada preview
    DetailKostScreen(navController = rememberNavController())
}
