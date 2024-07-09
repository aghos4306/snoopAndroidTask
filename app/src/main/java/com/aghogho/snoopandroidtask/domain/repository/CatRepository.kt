package com.aghogho.snoopandroidtask.domain.repository

import com.aghogho.snoopandroidtask.data.remote.cat_dto.CatDto

interface CatRepository {
    suspend fun getListOfCatBreed(): List<CatDto>
}
