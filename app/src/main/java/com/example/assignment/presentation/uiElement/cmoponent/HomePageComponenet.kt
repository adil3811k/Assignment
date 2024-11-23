package com.example.assignment.presentation.uiElement.cmoponent

import androidx.annotation.DrawableRes
import androidx.collection.intIntMapOf
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment.R

@Composable
fun SimpleIconsAndTextComposable(
    @DrawableRes icon: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Row{
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = modifier
                .size(30.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text=text,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun SimpleDetailCompose(
    value: String,
    tital: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text=value,
            color = Color(248, 182, 69),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text=tital,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun ImageComposable(
    planeName: String,
    completedPercentage: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .background(Color(250, 250, 255, 255))
            .padding(bottom = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter =painterResource(R.drawable.demo),
            contentDescription = null,
            modifier = modifier
                .padding(end = 20.dp)
                .size(80.dp)
        )
        Column(
            modifier.weight(1f)
        ){
            Text(
                text = planeName,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = planeName,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Box(
            Modifier.padding(end = 20.dp)
        ){
            Canvas(Modifier.size(80.dp)) {
                drawArc(
                    color = Color(248, 182, 69),
                    startAngle = 0f,
                    sweepAngle = 126f,
                    useCenter = false,
                    style = Stroke(
                        width = 5.dp.toPx(),
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    ),
                )
            }
            Text(
                text=completedPercentage,
                modifier = modifier
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun ExploreCompose(
   @DrawableRes Image: Int,
   Tital: String,
   Discription: String,
   onClick:()-> Unit,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.clickable{onClick()}
    ){
        Image(
            painter = painterResource(Image),
            contentDescription = null,
            modifier  = Modifier.size(width = 100.dp , height = 250.dp)
        )
        Column{
            Text(
                text=Tital,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text=Discription,
                fontWeight = FontWeight.ExtraLight,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
