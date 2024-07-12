package com.aghogho.snoopandroidtask.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aghogho.snoopandroidtask.presentation.cat_detail.CatDetailScreen
import com.aghogho.snoopandroidtask.presentation.cat_list.CatListScreen

@Composable
fun CatifyNavigationGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CatListScreen.route
    ) {
        composable(route = Screen.CatListScreen.route) {
            CatListScreen(navController = navController)
        }
        composable(
            route = Screen.CatDetailScreen.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: return@composable
            CatDetailScreen(navController = navController, id = id)
        }
    }
}
