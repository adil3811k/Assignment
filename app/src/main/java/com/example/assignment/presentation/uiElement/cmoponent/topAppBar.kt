package com.example.assignment.presentation.uiElement.cmoponent

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.assignment.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssingmentTopAppBar(modifier: Modifier = Modifier) {
    val topbarIconsmodifier = Modifier
        .padding(end = 20.dp)
        .size(24.dp)

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = Color.White,
            actionIconContentColor = Color.Black
        ),

        title = { Text("Dietsnap", color = Color(248, 182, 69)) },
        actions = {
            Icon(
                painter= painterResource(R.drawable.ball),
                contentDescription =  null,
                tint = Color.Black,
                modifier =topbarIconsmodifier
            )
            Icon(
                painter= painterResource(R.drawable.start),
                contentDescription =  null,
                tint = Color.Black,
                modifier = topbarIconsmodifier
            )
            Icon(
                painter= painterResource(R.drawable.message),
                contentDescription =  null,
                tint = Color.Black,
                modifier = topbarIconsmodifier
            )
        }
    )
}