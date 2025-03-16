package com.example.myfirstapp

import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFF0F5)) // Warna pastel pink lembut
                ) { innerPadding ->
                    Greeting(
                        name = "Athaya",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var buttonText by remember { mutableStateOf("Klik Aku!") } // State untuk tombol

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Tambahkan icon
        Icon(
            painter = painterResource(id = android.R.drawable.star_big_on),
            contentDescription = "Star Icon",
            tint = Color(0xFFFFC107),
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Card untuk tampilan lebih gemas
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFD1DC)
            ),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Hello, $name! 😊",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6A0572),
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Tombol interaktif
        Button(
            onClick = {
                buttonText = if (buttonText == "Klik Aku!") "Terima kasih! 💖" else "Klik Aku!"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A0572) // Warna ungu pastel
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = buttonText,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstAppTheme {
        Greeting("Android")
    }
}
