package tw.edu.pu.s1100706

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import tw.edu.pu.s1100706.ui.theme.S1100706Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S1100706Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current  //取得App的運行環境
    val activity = (context as Activity)  //取得App運行的活
    var appear by remember { mutableStateOf(true) }
    Column {



        Image(
            painter = painterResource(id = R.drawable.maria),
            contentDescription = "圖片",

            )
        Text(
            text = "主要機構",
            fontSize = 25.sp,
            color = Color.Red,

            modifier = modifier
         )
        Button(onClick = {
            //your onclick code here
        }) {
            if (appear) Text(text = "台中市愛心家園")
            else Text(text = "瑪利亞學園")
        }
        Image(
                painter = androidx.compose.ui.res.painterResource(id = tw.edu.pu.s1100706.R.drawable.lovehome),
                contentDescription = "服務總覽"
            )


        Button(onClick = {
            //your onclick code here
        }) {
            Text(text = "瑪利亞學園")
        }
        Image(
                painter = androidx.compose.ui.res.painterResource(id = tw.edu.pu.s1100706.R.drawable.campus),
        contentDescription = "台中市愛心家園"
        )


        Button(onClick = {
                    activity.finish() })


    }


        }

fun Button(onClick: () -> Unit) {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    S1100706Theme {
        Greeting2("Android")
    }
}