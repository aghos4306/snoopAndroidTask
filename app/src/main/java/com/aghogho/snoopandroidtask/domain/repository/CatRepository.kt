package com.aghogho.snoopandroidtask.domain.repository

import com.aghogho.snoopandroidtask.data.remote.cat_dto.CatDto
import com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto.CatDetailDto

interface CatRepository {
    suspend fun getListOfCatBreed(): List<CatDto>
    suspend fun getCatDetailedInfo(id: String): CatDetailDto
}
