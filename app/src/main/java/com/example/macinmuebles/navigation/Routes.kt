package com.example.macinmuebles.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val icon: ImageVector,
    val title: String,
    val route: String
) {
    object HomeView : Routes(Icons.Default.Home, "Últimas", "HomeView")
    object DetailPostView : Routes(Icons.Default.Home, "Detalle", "DetailPostView")
    object SearchView : Routes(Icons.Default.Search, "Buscador", "SearchView")
    object SettingsView : Routes(Icons.Default.Settings, "Ajustes", "SettingsView")
}