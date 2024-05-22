package tw.edu.pu.s1100706

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import tw.edu.pu.s1100706.ui.theme.S1100706Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S1100706Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var appear by remember { mutableStateOf(true) }
    Column{
    Image(
        painter = painterResource(id = R.drawable.maria),
        contentDescription = "圖片",

    )

    Text(
        text = "簡介",
        fontSize = 25.sp,
        color = Color.Blue,

        modifier = modifier
    )
        Button(
            onClick = { appear = !appear }
        ) {
            if (appear) Text(text = "作者:資科三B鍾明昉")
            else Text(text = "服務總覽")
        }
        AnimatedVisibility(
            visible = appear,
            enter =fadeIn(
                initialAlpha=0.1f ,
                animationSpec = tween(durationMillis = 3000)),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 3000))

        )
        {
            Image(
                painter = painterResource(id = R.drawable.service),
                contentDescription = "服務總覽"
            )
            Text(text = "瑪利亞基金會服務總覽")
        }
        AnimatedVisibility(
                visible = !appear,
            enter =fadeIn(
                initialAlpha=0.1f ,
                animationSpec = tween(durationMillis = 3000)),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 3000))
        ) {
        Image(
            painter = painterResource(id = R.drawable.unnamed),
            contentDescription = "作者:資科三B鍾明昉"
        )
            Text(text ="關於App作者")
    }}

    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    S1100706Theme {
        Greeting("Android")
    }
}