package com.example.macinmuebles.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.macinmuebles.model.PostModel
import com.example.macinmuebles.viewModel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCard(post: PostModel, navController: NavController, viewModel: PostViewModel) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        onClick = {
            //viewModel.onSelectPost(post)
            //navController.navigate("DetailPostView")
        },
        //elevation = CardDefaults.cardElevation(
        //    defaultElevation = 6.dp
        //),
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
        ) {
            val image =
                rememberImagePainter(data = post.imageFront[0])
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(20.dp))
                )
                Box(
                    modifier = Modifier
                        .zIndex(10f)
                        .padding(vertical = 12.dp, horizontal = 8.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 16.dp)


                ) {
                    Row(
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(
                            Modifier
                                .weight(2.5f)
                        ) {
                            Text(
                                text = post.title,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                            )
                            Row(
                                modifier = Modifier
                                    .padding(top = 8.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Place,
                                    contentDescription = "place",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = post.locality,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 13.sp,
                                )
                            }

                        }
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            textAlign = TextAlign.Right,
                            text = if (post.price.contains(
                                    "consulte",
                                    true
                                )
                            ) "CONSULTAR" else post.price,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                        )
                    }
                }
            }

        }
    }
}