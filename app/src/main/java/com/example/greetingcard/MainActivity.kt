package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    LearnLayoutModifiers()
                }
            }
        }
    }
}

// Adding Image And Using ContentScale to Scale it and Using the Opacity Feature
@Composable
fun GreetingImage(modifier: Modifier = Modifier, name: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.5F)
        BirthDayGreetingText(
            name = name,
            from = from,
            modifier
                .padding(8.dp)
                .fillMaxSize())
    }
}

// Using Column and Learning how to use padding with modifier and Arrangement with Column
@Composable
fun BirthDayGreetingText(name: String, from: String, modifier: Modifier = Modifier) {
    // Using Column to arrange the children without overlap vertically
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,

        ) {
        // Adding String Resource
        Text(
            text = stringResource(R.string.happy_birthday_text) +" ${name}!",
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

// Using Background Color to the text using modifier
@Composable
fun LearnLayoutModifiers(modifier: Modifier = Modifier){
    Text(
        text = "Hello World!",
        modifier = modifier.background(color = Color.Green)

    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        LearnLayoutModifiers()
    }
}