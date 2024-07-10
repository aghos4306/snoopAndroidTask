package com.aghogho.snoopandroidtask.domain.usecases.cat_detail

import android.util.Log
import com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto.toCatDetailModel
import com.aghogho.snoopandroidtask.domain.model.CatDetailModel
import com.aghogho.snoopandroidtask.domain.repository.CatRepository
import com.aghogho.snoopandroidtask.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCatDetailedInfoUseCase @Inject constructor(
    private val catRepository: CatRepository
) {
    operator fun invoke(id: String): Flow<Resource<CatDetailModel>> = flow {
        try {
            emit(Resource.Loading())
            val catDetailData = catRepository.getCatDetailedInfo(id).toCatDetailModel()
            emit(Resource.Success(catDetailData))
        } catch (e: HttpException) {
            Log.e("GetCatDetailedInfoUseCase", "HTTP error: ${e.response()?.errorBody()?.string()}")
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred..."))
        } catch (e: IOException) {
            Log.e("GetCatDetailedInfoUseCase", "Network error: ${e.localizedMessage}")
            emit(Resource.Error("Error fetching data, check your network..."))
        }
    }
}
