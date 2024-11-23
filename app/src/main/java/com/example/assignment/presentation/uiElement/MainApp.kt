package com.example.assignment.presentation.uiElement

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment.presentation.uiState.MainViewModel


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<MainViewModel>()
    val homeState = viewModel.homeState.collectAsState()
    val foodState = viewModel.foodState.collectAsState()
    Scaffold(
        bottomBar = {}
    ) { paddinvalue->
        NavHost(
            navController = navController,
            startDestination = "HomeScreen"
        ){
            composable("HomeScreen"){
                HomeScreenOCompose(
                    homeState = homeState.value,
                    modifier = modifier.padding(paddinvalue),
                    navController = navController
                )
            }
            composable("FoodScreen"){
                FoodScreen(
                    navController = navController,
                    foodState = foodState.value
                )
            }
        }
    }
}