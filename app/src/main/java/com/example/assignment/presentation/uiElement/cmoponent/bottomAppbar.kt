package com.example.assignment.presentation.uiElement.cmoponent

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import com.example.assignment.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource


private data class BottomUtil(
    @DrawableRes val icon: Int,
    val lable: String
)

private val list = listOf(
    BottomUtil(
        R.drawable.bottom_icon_1,
        "Activity"
    ),
    BottomUtil(
        R.drawable.bottom_icon_2,
        "Goal"
    ),BottomUtil(
        R.drawable.bottom_icon_3,
        "Camera"
    ),BottomUtil(
        R.drawable.bottom_icon_4,
        "Feed"
    ),BottomUtil(
        R.drawable.bottom_icon_5,
        "Profile"
    )
)


@Composable
fun AssingmentBottomAppBar(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = Color(248, 248, 248)
    ) {
        list.forEach {itme->
            NavigationBarItem(
                selected = if (itme.icon == R.drawable.bottom_icon_1) true else false,
                onClick = {},
                icon = { Icon(
                    painter =painterResource(itme.icon),
                    contentDescription =  null,
                    tint = Color.Unspecified)
                       },
                label = { Text(itme.lable) },
            )
        }
    }
}