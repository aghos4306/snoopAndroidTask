package com.aghogho.snoopandroidtask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aghogho.snoopandroidtask.presentation.cat_list.CatListScreen
import com.aghogho.snoopandroidtask.presentation.screen.Screen
import com.aghogho.snoopandroidtask.presentation.ui.theme.SnoopAndroidTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnoopAndroidTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController, 
                        startDestination = Screen.CatListScreen.route
                    ) {
                        composable(route = Screen.CatListScreen.route) {
                            CatListScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
