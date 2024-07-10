package com.aghogho.snoopandroidtask.domain.model

import com.aghogho.snoopandroidtask.data.remote.cat_dto.Image

data class CatModel(
    val id: String,
    val image: Image?,
    val name: String,
    val origin: String
)
