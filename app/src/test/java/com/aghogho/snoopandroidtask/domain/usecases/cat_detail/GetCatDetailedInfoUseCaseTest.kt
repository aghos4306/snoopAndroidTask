package com.aghogho.snoopandroidtask.domain.usecases.cat_detail

import com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto.CatDetailDto
import com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto.toCatDetailModel
import com.aghogho.snoopandroidtask.domain.model.CatDetailModel
import com.aghogho.snoopandroidtask.domain.repository.CatRepository
import com.aghogho.snoopandroidtask.mock_model.MockCatDetailDto
import com.aghogho.snoopandroidtask.util.Resource
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

@RunWith(MockitoJUnitRunner::class)
class GetCatDetailedInfoUseCaseTest {

    @Mock
    private lateinit var catRepository: CatRepository
    private lateinit var getCatDetailedInfoUseCase: GetCatDetailedInfoUseCase

    @Before
    fun setUp() {
        getCatDetailedInfoUseCase = GetCatDetailedInfoUseCase(catRepository)
    }

    @Test
    fun `invoke should emit loading and then success when data is fetched successfully`() = runTest {
        val catDetailDto = MockCatDetailDto.mockCatDetailDto
        val id = "abcd"
        Mockito.`when`(catRepository.getCatDetailedInfo(id)).thenReturn(catDetailDto)

        val flow = getCatDetailedInfoUseCase(id)
        val result = flow.toList()

        assertEquals(2, result.size)
        assertEquals(Resource.Loading<CatDetailModel>(), result[0])
        assertEquals(Resource.Success(catDetailDto.toCatDetailModel()), result[1])
    }

    @Test
    fun `invoke should emit loading and then error when HttpException is thrown`() = runTest {
        val id = "abcd"
        val exception = HttpException(
            Response.error<CatDetailDto>(
                404,
                ResponseBody.create("application/json".toMediaTypeOrNull(), "{\"message\":\"Not found\"}")
            )
        )

        Mockito.`when`(catRepository.getCatDetailedInfo(id)).thenThrow(exception)

        val flow = getCatDetailedInfoUseCase(id)
        val result = flow.toList()

        val errorResult = result[1] as Resource.Error<CatDetailModel>

        assertEquals(2, result.size)
        assertTrue(result[0] is Resource.Loading)
        assertEquals("HTTP 404 Response.error()", errorResult.message)
    }

    @Test
    fun `invoke should emit loading and then error when IOException is thrown`() = runTest {
        val id = "abcd"
        val exception = IOException("Network error")

        runBlocking {
            Mockito.`when`(catRepository.getCatDetailedInfo(id)).thenAnswer { throw exception }
        }

        val flow = getCatDetailedInfoUseCase(id)
        val result = flow.toList()

        val errorResult = result[1] as Resource.Error<CatDetailModel>

        assertEquals(2, result.size)
        assertTrue(result[0] is Resource.Loading)
        assertEquals("Error fetching data, check your network...", errorResult.message)
    }

}
