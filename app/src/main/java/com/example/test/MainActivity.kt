package com.example.test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var num1 by remember {
                mutableStateOf("0")
            }
            var num2 by remember {
                mutableStateOf("0")
            }

            TestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        TextField(value = num1, onValueChange = {
                            num1=it
                        })
                        TextField(value = num2, onValueChange = {
                            num2=it
                        })
                        Row {
                            Button(onClick = {
                                var result = num1.toInt() + num2.toInt()
                                Toast.makeText(applicationContext,"Result is : $result",Toast.LENGTH_SHORT).show()
                            }) {
                                Text(text = "Add")
                            }
                            Button(onClick = {
                                var result = num1.toInt() - num2.toInt()
                                Toast.makeText(applicationContext,"Result is : $result",Toast.LENGTH_SHORT).show()
                            }) {
                                Text(text = "Sub")
                            }
                        }

                    }
                }
            }
        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        Greeting("ADHI")
    }
}
*/