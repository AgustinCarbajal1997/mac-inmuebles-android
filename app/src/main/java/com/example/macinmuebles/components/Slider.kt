package com.example.macinmuebles.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue


@ExperimentalPagerApi
@Composable
fun SliderDetailPost(
    imageSlider: List<String>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(initialPage = 0)

    //LaunchedEffect(Unit) {
    //    while (true) {
    //        yield()
    //        delay(2600)
    //        pagerState.animateScrollToPage(
    //            page = (pagerState.currentPage + 1) % (pagerState.pageCount)
    //        )
    //    }
    //}

    Column {
        HorizontalPager(
            count = imageSlider.size,
            state = pagerState,
            //contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
                .fillMaxWidth()
        ) { page ->
            Card(
                shape = RoundedCornerShape(0.dp),
               // modifier = Modifier
               //     .graphicsLayer {
               //         val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
//
               //         lerp(
               //             start = 0.85f,
               //             stop = 1f,
               //             fraction = 1f - pageOffset.coerceIn(0f, 1f)
               //         ).also { scale ->
               //             scaleX = scale
               //             scaleY = scale
               //         }
//
               //         alpha = lerp(
               //             start = 0.5f,
               //             stop = 1f,
               //             fraction = 1f - pageOffset.coerceIn(0f, 1f)
               //         )
               //     }
            ) {
                Image(
                    painter = rememberImagePainter(data = imageSlider[page]),
                    contentDescription = imageSlider[page],
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 12f)
                )
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
    }
}
