package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        name = "Android",
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(R.drawable.android_logo)
        Profile(
            image = image,
            name = name,
            position = "Android Developer",
            modifier = Modifier.weight(4f)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            ContactInfo(
                icon = Icons.Rounded.Call,
                description = "Phone number",
                info = "012-345-6789"
            )
            ContactInfo(
                icon = Icons.Rounded.Share,
                description = "Account",
                info = "@AndroidDev"
            )
            ContactInfo(
                icon = Icons.Rounded.Email,
                description = "Email address",
                info = "example@android.com"
            )
        }
    }
}

@Composable
fun Profile(image: Painter, name: String, position: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = name,
            fontSize = 64.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = position,
            color = Color(0xFF3DDC84),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun ContactInfo(icon: ImageVector, description: String, info: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = Color(0xFF3DDC84)
        )
        Text(
            text = info,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ContactInfoPreview() {
    BusinessCardTheme {
        ContactInfo(
            icon = Icons.Rounded.Call,
            description = "Phone number",
            info = "012-345-6789"
        )
    }
}