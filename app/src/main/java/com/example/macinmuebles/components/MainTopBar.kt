package com.example.macinmuebles.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import okhttp3.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    navController: NavController,
    showBackButton: Boolean = false,
    onClickBackButton: () -> Unit,
    onClickAction: () -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    //fun onShowBackButton(): Boolean {
    //    return navBackStackEntry?.destination?.route == Routes.DetailPostView.route ||
    //            navBackStackEntry?.destination?.route == "${Routes.CategoryListView.route}/{id}"
    //}

    fun getCategory(): String {
        return when(navBackStackEntry?.arguments?.getInt("id")){
            107 -> "Destacados"
            25 -> "Agro"
            108 -> "Bienestar"
            39 -> "Ciencia"
            60 -> "Clima"
            27 -> "Cultura"
            21 -> "Curiosidades"
            0 -> "Clasificados"
            else -> "Otros"
        }
    }

    TopAppBar(
        title = {
                Text(text = title)
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        navigationIcon = {
            //if (onShowBackButton()) {
            //    IconButton(onClick = { onClickBackButton() }) {
            //        Icon(
            //            imageVector = Icons.Default.ArrowBack,
            //            contentDescription = "",
            //            tint = Color.White
            //        )
            //    }
            //}
        },
        //actions = {
        //    if (!showBackButton) {
        //        IconButton(onClick = { onClickAction() }) {
        //            Icon(
        //                imageVector = Icons.Default.Search,
        //                contentDescription = "",
        //                tint = Color.White
        //            )
        //        }
        //    }
        //}
    )
}