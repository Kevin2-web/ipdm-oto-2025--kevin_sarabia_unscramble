package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.superheroes.ui.theme.SuperheroesTheme

data class Hero(val name: String, val description: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HeroList(
                        heroes = listOf(
                            Hero("Águila Roja", "Maestro del vuelo y la visión láser."),
                            Hero("Chispa", "Controla la electricidad y la velocidad."),
                            Hero("Titán Verde", "Fuerza bruta con corazón noble."),
                            Hero("Sombra", "Invisible y rápida como el viento.")
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun HeroList(heroes: List<Hero>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(heroes) { hero ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = hero.name, style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = hero.description, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}