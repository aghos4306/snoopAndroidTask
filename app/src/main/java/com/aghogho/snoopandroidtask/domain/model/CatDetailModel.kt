package com.aghogho.snoopandroidtask.domain.model

data class CatDetailModel(
    val id: String,
    val imageUrl: String,
    val name: String,
    val origin: String,
    val description: String,
    val temperament: String,
    val lifeSpan: String,
    val wikipediaUrl: String
)
