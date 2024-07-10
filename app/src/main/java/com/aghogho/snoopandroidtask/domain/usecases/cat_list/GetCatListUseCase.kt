package com.aghogho.snoopandroidtask.domain.usecases.cat_list

import com.aghogho.snoopandroidtask.data.remote.cat_dto.toCatModel
import com.aghogho.snoopandroidtask.domain.model.CatModel
import com.aghogho.snoopandroidtask.domain.repository.CatRepository
import com.aghogho.snoopandroidtask.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCatListUseCase @Inject constructor(
    private val catRepository: CatRepository
) {
    operator fun invoke(): Flow<Resource<List<CatModel>>> = flow {
        try {
            emit(Resource.Loading())
            val catsData = catRepository.getListOfCatBreed().map {
                it.toCatModel()
            }
            emit(Resource.Success(catsData))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred..."))
        } catch (e: IOException) {
            emit(Resource.Error("Error fetching data, check your network..."))
        }
    }
}
