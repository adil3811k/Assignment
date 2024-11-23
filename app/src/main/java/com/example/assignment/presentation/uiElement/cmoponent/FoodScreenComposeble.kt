package com.example.assignment.presentation.uiElement.cmoponent

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.R
import com.example.assignment.domainLayer.food.NutritionInfoScaled
import okhttp3.internal.Util

val COLUM_BG = Color(253, 247, 247)
val ORAGE = Color(248, 185, 68)
@Composable
fun FoodDescription(
    content: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.padding(bottom = 20.dp)
    ){
        Text(
            text = "Description",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Composable
fun FoodMacroNutrients(
    nutritions: List<NutritionInfoScaled>,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        Text(
            text="Macros Nutrients",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            modifier = modifier.padding(start = 12.dp, bottom = 12.dp)
        )
        Column(
            modifier = modifier
                .padding(start = 12.dp)
                .fillMaxWidth(0.6f)
                .background(COLUM_BG)
                .clip(RoundedCornerShape(2))
                .border(2.dp, Color.Black, RoundedCornerShape(2)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text="Name", modifier = Modifier.padding(start = 12.dp).weight(1f),
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text="Value", modifier = Modifier.padding(start = 12.dp, end = 12.dp).weight(1f),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(
                Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(Color.Black))
            nutritions.forEach {nutrition->
                Row (
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text=nutrition.name, modifier = Modifier.padding(start = 12.dp).weight(1f),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text="${nutrition.value} ${nutrition.units}", modifier = Modifier.padding(start = 12.dp, end = 12.dp).weight(1f),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
fun FoodFact(
    facts: List<String>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(facts){fact->
            FactCompos(fact, modifier = modifier)
        }
    }
}

@Composable
private fun FactCompos(
    fact: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors().copy(containerColor = ORAGE, contentColor = Color.White),
        modifier = modifier
            .padding(top = 20.dp, bottom = 20.dp)
            .width(350.dp)
            .clip(RoundedCornerShape(2))
    ) {
        Text(
            text="Do you Know ?",
            modifier  = Modifier.padding(top = 20.dp , start = 30.dp , bottom = 20.dp),
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text=  fact,
            modifier = Modifier.padding(start = 12.dp , end = 12.dp , bottom = 20.dp),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun SimilarItermCompose(
    modifier: Modifier = Modifier
) {
    val list = listOf<ImageHalper>(
        ImageHalper(R.drawable.food_1 , "Chicken Tnadoor"),
        ImageHalper(R.drawable.food_2, "Pulav"),
        ImageHalper(R.drawable.food_3 , "")
    )
    LazyRow(
        modifier = modifier.padding(start = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(list){
            Box(
                modifier = Modifier.size(150.dp)
                    .clip(RoundedCornerShape(12.dp))
            ){
                Image(
                    painter = painterResource(it.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 20.dp)
                )
                Text(
                    text =  it.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color =  Color.White,
                    modifier  = Modifier
                        .padding(start = 12.dp, top = 12.dp)
                        .align(Alignment.BottomCenter)
                        .fillMaxSize()
                )
            }
        }
    }
}


private data class ImageHalper(
    @DrawableRes val image: Int,
    val name: String
)