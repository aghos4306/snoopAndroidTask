package com.aghogho.snoopandroidtask.data.remote

import com.aghogho.snoopandroidtask.data.remote.cat_dto.CatDto
import com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto.CatDetailDto
import com.aghogho.snoopandroidtask.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CatApiService {
    @GET("v1/breeds")
    @Headers("x-api-key: $API_KEY")
    suspend fun getListOfCatBreed(): List<CatDto>

    @GET("v1/images/{id}")
    @Headers("x-api-key: $API_KEY")
    suspend fun getCatDetailedInfo(@Path("id") id: String): CatDetailDto
}
