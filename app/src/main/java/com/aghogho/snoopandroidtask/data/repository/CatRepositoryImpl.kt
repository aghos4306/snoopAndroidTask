package com.aghogho.snoopandroidtask.data.repository

import com.aghogho.snoopandroidtask.data.remote.CatApiService
import com.aghogho.snoopandroidtask.data.remote.cat_dto.CatDto
import com.aghogho.snoopandroidtask.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val catApiService: CatApiService
): CatRepository {
    override suspend fun getListOfCatBreed(): List<CatDto> {
        return catApiService.getListOfCatBreed()
    }

}
