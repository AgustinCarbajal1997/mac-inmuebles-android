package com.example.macinmuebles.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.macinmuebles.R
import com.example.macinmuebles.components.SliderDetailPost
import com.example.macinmuebles.viewModel.PostViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun DetailPostView(viewModel: PostViewModel, pad: PaddingValues) {
    ContentDetailPostView(viewModel, pad)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ContentDetailPostView(viewModel: PostViewModel, pad: PaddingValues) {
    val post by viewModel.selectedPost.collectAsState()
    val scroll = rememberScrollState(0)
    println("post.imageFront.size" + post.imageFront)
    Column(
        modifier = Modifier
            .verticalScroll(scroll)
    ) {
        SliderDetailPost(imageSlider = post.images)
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = post.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "${post.neighborhood}, ${post.locality}",
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "¿Qué ofrece este lugar?",
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
            )
            if (post.bedrooms > 0) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.dormitorios),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "${post.bedrooms} habitaciones",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.bathrooms > 0) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.bath),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "${post.bedrooms} habitaciones",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.garage) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.cocheras),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Cochera",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.balcony) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.balcon),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Balcón",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.pool) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.pileta),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Piscina",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.barbecue) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.parrilla),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Parrilla",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.privateNeighborhood) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.barrioprivado),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Barrio Privado",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.backyard) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.patio),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Jardín",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.alarm) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.alarma),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Alarma",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.sum) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.quincho),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Quincho",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.elevator) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.ascensor),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Ascensor",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.laundry) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.lavadero),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Lavadero",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.credit) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.credito),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Crédito",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.services) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.servicios),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Servicios",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (post.measures > 0) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.metros_cuadrados),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "${post.measures} m²",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

            }

            Text(
                text = "Descripción del inmueble",
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
            )
            Text(
                text = post.sanitizedHtml,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colorScheme.primary
            )

        }

    }
}