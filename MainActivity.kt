package com.thenexoteam.nexoos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexoOSApp()
        }
    }
}

@Composable
fun NexoOSApp() {
    var darkMode by remember { mutableStateOf(true) }
    var brightness by remember { mutableStateOf(70f) }
    var animationsEnabled by remember { mutableStateOf(true) }
    var status by remember { mutableStateOf("Listo para personalizar") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Nexo-OS Personalización", style = MaterialTheme.typography.headlineLarge)

        // Dark Mode
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Text("Tema Oscuro", modifier = Modifier.weight(1f))
            Switch(checked = darkMode, onCheckedChange = { darkMode = it })
        }

        // Brightness
        Text("Brillo: ${brightness.toInt()}%")
        Slider(
            value = brightness,
            onValueChange = { brightness = it },
            valueRange = 0f..100f
        )

        // Animations
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Text("Animaciones activadas", modifier = Modifier.weight(1f))
            Switch(checked = animationsEnabled, onCheckedChange = { animationsEnabled = it })
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { status = "✅ Cambios aplicados correctamente" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Aplicar cambios")
        }

        Text(status, style = MaterialTheme.typography.bodyLarge)
    }
}