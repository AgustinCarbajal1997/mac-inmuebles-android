package com.example.macinmuebles.views

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.macinmuebles.components.BottomNav
import com.example.macinmuebles.components.MainTopBar
import com.example.macinmuebles.navigation.NavManager
import com.example.macinmuebles.navigation.Routes
import com.example.macinmuebles.viewModel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabView(viewModel: PostViewModel) {
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.HomeView,
        Routes.SearchView,
        Routes.SettingsView
    )

    fun onClickBackButton() {
        navController.popBackStack()
    }

    Scaffold(
        //topBar = {
        //    MainTopBar(
        //        title = "MAC Inmuebles",
        //        navController,
        //        onClickBackButton = { onClickBackButton() }) {}
        //},
        bottomBar = {
            BottomNav(navController, navigationRoutes)
        }
    ) { pad ->
        NavManager(navController, viewModel, pad)
    }
}