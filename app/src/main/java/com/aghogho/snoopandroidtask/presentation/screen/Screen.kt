package com.aghogho.snoopandroidtask.presentation.screen

sealed class Screen(val route: String) {
    data object CatListScreen: Screen("cat_list_screen")
    data object CatDetailScreen: Screen("cat_detail_screen")
}
