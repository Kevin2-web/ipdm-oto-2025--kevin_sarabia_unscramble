
package com.example.dessertclicker

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dessertclicker.ui.theme.DessertClickerTheme

class MainActivity : ComponentActivity() {

    private val TAG = "CicloVidaActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() -> Iniciado")
        setContent {
            DessertClickerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DessertClickerApp()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() -> Visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() -> Interactivo")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() -> Pausado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() -> Oculto")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() -> Destruido")
    }
}

@Composable
fun DessertClickerApp() {
    var clicks by remember { mutableStateOf(0) }
    var currentDessert by remember { mutableStateOf("Cupcake") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.padding(24.dp)
    ) {
        Text(text = "Postre seleccionado: $currentDessert", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Clicks: $clicks", style = MaterialTheme.typography.bodyLarge)

        Button(onClick = {
            clicks++
            currentDessert = when {
                clicks < 5 -> "Cupcake"
                clicks < 10 -> "Donut"
                clicks < 15 -> "Eclair"
                else -> "Pie"
            }
        }) {
            Text(text = "¡Click aquí!")
        }

        LifecycleInfo()
    }
}

@Composable
fun LifecycleInfo() {
    val lifecycleSteps = listOf(
        "onCreate() -> Iniciado",
        "onStart() -> Visible",
        "onResume() -> Interactivo",
        "onPause() -> Pausado",
        "onStop() -> Oculto",
        "onDestroy() -> Destruido"
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BasicText("Ciclo de Vida de la Actividad:", style = MaterialTheme.typography.titleMedium)
        lifecycleSteps.forEach {
            Text(text = it, style = MaterialTheme.typography.bodySmall)
        }
    }
}
