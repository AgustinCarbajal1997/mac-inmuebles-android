package com.example.macinmuebles.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.macinmuebles.components.ActivityIndicator
import com.example.macinmuebles.components.PostCard
import com.example.macinmuebles.viewModel.PostViewModel

@Composable
fun HomeView(viewModel: PostViewModel, navController: NavController, pad: PaddingValues){
    ContentHomeView(viewModel, navController, pad)
}

@Composable
fun ContentHomeView(viewModel: PostViewModel, navController:NavController, pad: PaddingValues){
    val posts by viewModel.posts.collectAsState()
    val loading by viewModel.loading.collectAsState()
    if (loading) {
        ActivityIndicator(pad)
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = androidx.compose.ui.Modifier.padding(pad)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                itemsIndexed(posts) { idx, item ->
                    Box(
                        modifier = Modifier
                            .padding(top = if (idx > 1) 0.dp else 16.dp)
                            .clickable {

                            }
                    ) {
                        PostCard(post = item, navController, viewModel)
                    }
                }
            }
        }
    }
}