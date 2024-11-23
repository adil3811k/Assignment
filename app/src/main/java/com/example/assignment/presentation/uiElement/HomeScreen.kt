package com.example.assignment.presentation.uiElement

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import com.example.assignment.presentation.uiElement.cmoponent.CircleComposable
import com.example.assignment.R
import com.example.assignment.domainLayer.home.HomeDetail
import com.example.assignment.presentation.uiElement.cmoponent.AssingmentBottomAppBar
import com.example.assignment.presentation.uiElement.cmoponent.AssingmentTopAppBar
import com.example.assignment.presentation.uiElement.cmoponent.ExploreCompose
import com.example.assignment.presentation.uiElement.cmoponent.ImageComposable
import com.example.assignment.presentation.uiElement.cmoponent.SimpleDetailCompose
import com.example.assignment.presentation.uiElement.cmoponent.SimpleIconsAndTextComposable
import com.example.assignment.presentation.uiState.HomeState

val YELLO = Color(248, 182, 69)

@Composable
fun HomeScreenOCompose(
    homeState: HomeState,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
            AssingmentTopAppBar()
        },
        bottomBar = {
            AssingmentBottomAppBar()
        }
    ) {paddingvalue->
        val scrollBehavior = rememberScrollState()
        AnimatedContent(targetState =  homeState, label = "") {homeState->
            when(homeState){
                is HomeState.Error -> {
                    Box(
                        modifier = modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(homeState.message)
                    }
                }
                HomeState.Loading -> {Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){ CircularProgressIndicator() }}
                is HomeState.Success -> {
                    ManiBody(
                        navController = navController,
                        paddingvalue  =paddingvalue,
                        scrollState = scrollBehavior,
                        homeDetail = homeState.homeDetail
                    )
                }
            }
        }

    }

}

@Composable
fun ManiBody(
    navController: NavController,
    paddingvalue: PaddingValues,
    scrollState: ScrollState,
    homeDetail: HomeDetail,
    modifier: Modifier = Modifier
) {
    Column(
        modifier =modifier.padding(paddingvalue).padding(10.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text ="Today",
            fontWeight = FontWeight.SemiBold,
            fontSize =  MaterialTheme.typography.headlineLarge.fontSize,
        )
        Text(
            text = "Saturday 25th Nov",
            fontWeight = FontWeight.ExtraLight,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            CircleComposable()
            Icon(
                imageVector =  Icons.Default.KeyboardArrowRight,
                contentDescription =  null,
                tint = YELLO,
                modifier = Modifier
                    .clickable{navController.navigate("FoodScreen")}
                    .size(30.dp)
                    .align(Alignment.CenterEnd)
            )
        }
        Row(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SimpleIconsAndTextComposable(
                R.drawable.apple,
                "Diet Pts",
            )
            Spacer(Modifier.width(20.dp))
            SimpleIconsAndTextComposable(
                R.drawable.dumble,
                "Exercise Pts"
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SimpleDetailCompose(
                "1500",
                "cal"
            )
            SimpleDetailCompose(
                "3/5",
                "Days"
            )
            SimpleDetailCompose(
                "88",
                "Health Score"
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp , bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Canvas(Modifier) {
                drawCircle(
                    color = YELLO,
                    radius = 5.dp.toPx()
                )
            }
            Spacer(Modifier.width(30.dp))
            Canvas(Modifier) {
                drawCircle(
                    color = Color.Gray,
                    radius = 5.dp.toPx()
                )
            }
        }
        Text(
            text ="Your Goals",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 30.dp).align(Alignment.Start)
        )
        ImageComposable(
            homeDetail.data.section_1.plan_name,
            homeDetail.data.section_1.progress
        )
        Text(
            text = "Explore",
            style = MaterialTheme.typography.headlineSmall,
            modifier  = Modifier
                .padding(bottom = 20.dp)
                .align(Alignment.Start)
        )
        ExploreCompose(
            R.drawable.explore_1,
            "Find Diet",
            "Find premade dies according to you cousin",
            {navController.navigate("FoodScreen")}
        )
        ExploreCompose(
            R.drawable.explore_2,
            "Find Nutritionist",
            "Get Customizes diets to achieve you health",
            {}
        )
    }
}