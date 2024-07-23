package com.example.macinmuebles.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.macinmuebles.viewModel.PostViewModel
import com.example.macinmuebles.views.HomeView
import com.example.macinmuebles.views.SearchView
import com.example.macinmuebles.views.SettingsView

@Composable
fun NavManager(navHostController: NavHostController, viewModel: PostViewModel, pad: PaddingValues){
    NavHost(navController = navHostController, startDestination = Routes.HomeView.route){
        composable(Routes.HomeView.route){
            HomeView(viewModel, navHostController, pad)
        }
        composable(Routes.SearchView.route){
            SearchView()
        }
        composable(Routes.SettingsView.route){
            SettingsView()
        }
        //composable(Routes.DetailPostView.route){
        //    DetailPostView(viewModel, pad)
        //}
        //composable(Routes.SearchView.route){
        //    SearchView(pad, viewModel, navHostController)
        //}
        //composable(Routes.CategoryView.route){
        //    CategoryView(viewModel, pad, navHostController)
        //}
        //composable("${Routes.CategoryListView.route}/{id}", arguments = listOf(
        //    navArgument("id") { type = NavType.IntType }
        //)){
        //    val id = it.arguments?.getInt("id") ?: 0
        //    CategoryListView(viewModel, pad, id, navHostController)
        //}
    }
}