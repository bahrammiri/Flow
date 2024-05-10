package com.example.myapplication

import CountViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<CountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(countViewModel: CountViewModel) {

    val collectedValue = remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { countViewModel.counter() }) {
            Text(text = "Start Counter")
        }
        Text(text = "Count: ${countViewModel.count.value}")


        Button(onClick = { countViewModel.counter2() }) {
            Text(text = "Start Counter2")
        }
        Text(text = "Count: ${countViewModel.count2.value}")

        Button(onClick = {

            countViewModel.collectMyFlow(collectedValue)
        }

        ) {
            Text(text = "Start Counter3")
        }
        Text(text = "${collectedValue.value}")


    }
}
