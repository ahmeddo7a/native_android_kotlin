package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
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
                    BusinessCard()
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
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        BirthDayGreetingText(
            name = name,
            from = from,
            modifier
                .padding(8.dp)
                .fillMaxSize()
        )
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
            text = stringResource(R.string.happy_birthday_text) + " ${name}!",
            fontSize = 100.sp,
            lineHeight = 115.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            fontSize = 35.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}

// Using Background Color to the text using modifier
@Composable
fun LearnLayoutModifiers(modifier: Modifier = Modifier) {
    Text(
        text = "Hello World!",
        modifier = modifier.background(color = Color.Green)

    )

}


// Article Design Function Task
@Composable
fun ArticleDetails(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null)
        Text(
            text = stringResource(R.string.jetpack_compose_tutorial_title),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.jetcompose_first_description),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.jetcompose_second_description),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

// TaskManager Design Task
@Composable
fun TaskManger(modifier: Modifier = Modifier) {
    val  image = painterResource(id = R.drawable.ic_task_completed)
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = image, contentDescription = null)
        Text(
            text = stringResource(R.string.task_manager_title),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            )
        Text(
            text = stringResource(R.string.task_manager_description),
            fontSize = 16.sp
        )
    }
}

//Composable Description Design Task
@Composable
fun ComposableDescription(modifier: Modifier = Modifier){
    Column (modifier.fillMaxSize()){
        Row (modifier.weight(1F)){
            ComposableCard(
                title = stringResource(R.string.text_composable_title),
                description = stringResource(R.string.text_composable_description),
                myColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1F)
            )
            ComposableCard(
                title = stringResource(R.string.image_composable_title),
                description = stringResource(R.string.image_composable_description),
                myColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1F)
            )
        }
        Row (modifier.weight(1F)){
            ComposableCard(
                title = stringResource(R.string.row_composable_title),
                description = stringResource(R.string.row_composable_description),
                myColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1F)
            )
            ComposableCard(
                title = stringResource(R.string.column_composable_title),
                description = stringResource(R.string.column_composable_description),
                myColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1F)
            )
        }
    }
}
//Composable Reusable Card For Composable Description Task
@Composable
fun ComposableCard(modifier: Modifier = Modifier,title: String, description: String, myColor: Color){
    Column (
        modifier
            .background(color = myColor)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center

        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

//Build Business Card Design Task
@Composable
fun BusinessCard(modifier: Modifier = Modifier){
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        titleCard(fullName = "Ahmed Mamdouh", title = "Software Engineer", modifier = modifier.weight(0.7F))
        ContactInfo(modifier = modifier.weight(0.3F))
    }
}

@Composable
fun titleCard(modifier: Modifier = Modifier, fullName: String, title: String){
    val image = painterResource(id = R.drawable.pp)
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = fullName,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier, ){
    Column (
        modifier = modifier.padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        InfoRow(icon = R.drawable.telephone, title = "+201550815454", modifier = Modifier.padding(bottom = 8.dp))
        InfoRow(icon = R.drawable.user, title = "@AhmedMamdouh", modifier = Modifier.padding(bottom = 8.dp))
        InfoRow(icon = R.drawable.mail, title = "dev.ahmed.mm@gmail.com")

    }
}

@Composable
fun InfoRow(modifier: Modifier = Modifier, icon: Int, title: String){
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,

    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
        )
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 8.dp)
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