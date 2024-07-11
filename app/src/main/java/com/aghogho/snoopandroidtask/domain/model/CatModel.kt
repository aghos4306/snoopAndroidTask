package com.aghogho.snoopandroidtask.domain.model

import com.aghogho.snoopandroidtask.data.local.shared_pref.PreferenceHelper
import com.aghogho.snoopandroidtask.data.remote.cat_dto.Image

data class CatModel(
    val id: String,
    val image: Image?,
    val name: String,
    val origin: String,
    val referenceImageId: String?,
    val isFavourited: Boolean = false
) {
    fun withFavouriteStatus(preferenceHelper: PreferenceHelper): CatModel {
        return this.copy(isFavourited = preferenceHelper.isFavorite(id))
    }
}
