package com.example.assignment.presentation.uiElement

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment.domainLayer.food.FoodDetail
import com.example.assignment.domainLayer.food.NutritionInfoScaled
import com.example.assignment.presentation.uiElement.cmoponent.FoodDescription
import com.example.assignment.presentation.uiElement.cmoponent.FoodFact
import com.example.assignment.presentation.uiElement.cmoponent.FoodMacroNutrients
import com.example.assignment.presentation.uiElement.cmoponent.ImageComposeFoodScreen
import com.example.assignment.presentation.uiElement.cmoponent.SimilarItermCompose
import com.example.assignment.presentation.uiState.FoodState

@Composable
fun FoodScreen(
    navController: NavController,
    foodState: FoodState,
    modifier: Modifier = Modifier
    ) {
    Scaffold { padding ->
        AnimatedContent(foodState, label = "") { foodState->
            when(foodState){
                is FoodState.Error -> {
                    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center){ Text(foodState.message) }
                }
                FoodState.Loading ->{
                    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center){ CircularProgressIndicator() }
                }
                is FoodState.Success -> {
                    MainBody(
                        navController =navController ,
                        modifier = modifier.fillMaxSize(),
                        foodDetail = foodState.foodDetail
                    )
                }
            }
        }
    }
}

@Composable
fun MainBody(
    navController: NavController,
    foodDetail: FoodDetail,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {item{
        ImageComposeFoodScreen(
            navController = navController,
            score = foodDetail.data.health_rating.toString() ,
            name = foodDetail.data.name
        )

        FoodDescription(foodDetail.data.description ,modifier.padding(start = 12.dp))


        FoodMacroNutrients(
            nutritions = foodDetail.data.nutrition_info_scaled
        )
        FoodFact(facts = foodDetail.data.generic_facts)

        SimilarItermCompose()
    }
    }
}