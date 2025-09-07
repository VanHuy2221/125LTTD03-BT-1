package com.example.bt1_pvh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bt1_pvh.ui.theme.BT1_PVHTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BT1_PVHTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FractionCalculator(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FractionCalculator(modifier: Modifier = Modifier) {
    var num1 by remember { mutableStateOf("") }
    var den1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var den2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Phép cộng phân số", style = MaterialTheme.typography.titleLarge)

        // Nhập phân số 1
        OutlinedTextField(value = num1, onValueChange = { num1 = it }, label = { Text("Tử số 1") })
        OutlinedTextField(value = den1, onValueChange = { den1 = it }, label = { Text("Mẫu số 1") })

        // Nhập phân số 2
        OutlinedTextField(value = num2, onValueChange = { num2 = it }, label = { Text("Tử số 2") })
        OutlinedTextField(value = den2, onValueChange = { den2 = it }, label = { Text("Mẫu số 2") })

        Button(onClick = {
            val n1 = num1.toIntOrNull()
            val d1 = den1.toIntOrNull()
            val n2 = num2.toIntOrNull()
            val d2 = den2.toIntOrNull()

            if (n1 != null && d1 != null && n2 != null && d2 != null && d1 != 0 && d2 != 0) {
                val numerator = n1 * d2 + n2 * d1
                val denominator = d1 * d2
                result = "$numerator / $denominator"
            } else {
                result = "Lỗi: nhập sai hoặc mẫu số = 0"
            }
        }) {
            Text("Cộng phân số")
        }

        Text("Kết quả: $result")
    }
}

@Preview(showBackground = true)
@Composable
fun FractionCalculatorPreview() {
    BT1_PVHTheme {
        FractionCalculator()
    }
}
