package com.example.macinmuebles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.macinmuebles.ui.theme.MacinmueblesTheme
import com.example.macinmuebles.viewModel.PostViewModel
import com.example.macinmuebles.views.TabView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: PostViewModel by viewModels()
        setContent {
            MacinmueblesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TabView(viewModel)
                }
            }
        }
    }
}
