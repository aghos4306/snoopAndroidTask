package com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto

import com.aghogho.snoopandroidtask.domain.model.CatDetailModel

data class CatDetailDto(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    val breeds: List<Breed>?
)

fun CatDetailDto.toCatDetailModel(): CatDetailModel {
    val breedInfo = breeds?.firstOrNull()
    return CatDetailModel(
        id = id,
        imageUrl = url,
        name = breedInfo?.name ?: "Unknown Name",
        origin = breedInfo?.origin ?: "Unknown Origin",
        description = breedInfo?.description ?: "Unknown description",
        temperament = breedInfo?.temperament ?: "Unknown temperament",
        lifeSpan = breedInfo?.lifeSpan ?: "Unknown lifespan",
        wikipediaUrl = breedInfo?.wikipediaUrl ?: "unknown url"
    )
}
