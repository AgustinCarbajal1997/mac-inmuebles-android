package com.example.macinmuebles.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.macinmuebles.navigation.Routes

@Composable
fun BottomNav(navHostController: NavHostController, routes: List<Routes>) {

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .fillMaxHeight()


    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .zIndex(10f)
                .padding(16.dp)
                .shadow(
                    elevation = 10.dp,
                    RoundedCornerShape(50.dp)
                )
                .width(300.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color.White)
                .padding(20.dp)



        ) {
            val currentRoute = currentRoute(navHostController)
            routes.forEach { item ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(if (currentRoute == item.route) MaterialTheme.colorScheme.secondary else Color.White)
                        .padding(10.dp)
                        .clickable {
                            navHostController.navigate(item.route)
                        }

                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (currentRoute == item.route) Color.White else MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }
        }

        //routes.forEach { item ->
        //    NavigationBarItem(
        //        selected = currentRoute == item.route,
        //        onClick = { navHostController.navigate(item.route) },
        //        icon = {
        //            Icon(
        //                imageVector = item.icon,
        //                contentDescription = item.title,
        //                tint = MaterialTheme.colorScheme.secondary,
        //                modifier = Modifier.size(20.dp)
        //            )
        //        },
        //        label = {
        //            Text(
        //                text = item.title,
        //                color = if (currentRoute == item.route) Color.DarkGray else Color.Gray,
        //                fontSize = 12.sp,
        //                fontWeight = FontWeight.SemiBold
        //            )
        //        },
//
        //        )
        //}
    }
}


@Composable
fun currentRoute(navHostController: NavHostController): String? {
    val current by navHostController.currentBackStackEntryAsState()
    return current?.destination?.route
}