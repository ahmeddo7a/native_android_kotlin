package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(name = "Ahmed", from = "From Emma")
                }
            }
        }
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier, name: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.5F)
        BirthDayGreeting(
            name = name,
            from = from,
            modifier
                .padding(8.dp)
                .fillMaxSize())
    }
}

@Composable
fun BirthDayGreeting(name: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,

        ) {
        Text(
            text = "Happy Birthday $name!",
            fontSize = 100.sp,
            lineHeight = 115.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            fontSize = 35.sp,
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.End)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        GreetingImage(name = "Ahmed", from = "From Emma")
    }
}