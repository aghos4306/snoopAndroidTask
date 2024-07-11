package com.aghogho.snoopandroidtask.data.local.shared_pref

import android.content.Context
import javax.inject.Inject

class PreferenceHelper @Inject constructor(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("favorites_prefs", Context.MODE_PRIVATE)

    fun toggleFavoriteUsingPref(catId: String): Boolean {
        val isFavourited = sharedPreferences.getBoolean(catId, false)
        sharedPreferences.edit().putBoolean(catId, !isFavourited).apply()
        return !isFavourited
    }

    fun isFavorite(catId: String): Boolean {
        return sharedPreferences.getBoolean(catId, false)
    }
}
