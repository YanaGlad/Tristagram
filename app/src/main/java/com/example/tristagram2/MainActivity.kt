package com.example.tristagram2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tristagram2.ui.theme.Tristagram2Theme
import com.example.tristagram2.dto.Beer
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tristagram2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    model: BeerScreenViewModel = hiltViewModel(),
) {
    val viewState = model.beerList.collectAsState()

    BeerList(list = viewState.value)
}

@Composable
fun BeerList(list: List<Beer>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        list.forEach {
            Text(
                text = it.name,
                modifier = Modifier.padding(20.dp),
                fontSize = 24.sp,
            )
        }
    }
}
