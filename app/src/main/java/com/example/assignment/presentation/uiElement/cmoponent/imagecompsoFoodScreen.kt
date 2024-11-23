package com.example.assignment.presentation.uiElement.cmoponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment.R

@Composable
fun ImageComposeFoodScreen(
    navController: NavController,
    score: String,
    name: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .padding(bottom = 12.dp)
            .fillMaxWidth()
            .height(350.dp)
    ){
        Image(
            painter = painterResource(R.drawable.chiken),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
        Row (
            modifier = modifier
                .fillMaxSize()
                .padding(top = 30.dp)
                .clickable{navController.popBackStack()},
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ){
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                tint = Color.White,
                contentDescription = null
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text= "Back",
                color = Color.White
            )
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text="Food information",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = name,
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall
                )
            }
            Card(
                colors = CardDefaults.cardColors().copy(containerColor = Color(139f,139f,139f,0.50f), contentColor = Color.White),
                modifier = modifier.padding(end = 10.dp).clip(RoundedCornerShape(20))
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text=score,
                        style = MaterialTheme.typography.displayMedium
                    )
                    Spacer(Modifier.height(30.dp))
                    Text(
                        text ="Out of 100",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = modifier.padding(vertical = 10.dp)
                    )
                }
            }
        }
    }
}

