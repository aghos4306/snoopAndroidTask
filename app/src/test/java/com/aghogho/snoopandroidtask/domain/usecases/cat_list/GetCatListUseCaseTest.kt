package com.aghogho.snoopandroidtask.domain.usecases.cat_list

import com.aghogho.snoopandroidtask.data.remote.cat_dto.toCatModel
import com.aghogho.snoopandroidtask.domain.model.CatModel
import com.aghogho.snoopandroidtask.domain.repository.CatRepository
import com.aghogho.snoopandroidtask.mock_model.MockCatDto
import com.aghogho.snoopandroidtask.util.Resource
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.HttpException
import java.io.IOException

@RunWith(MockitoJUnitRunner::class)
class GetCatListUseCaseTest {

    @Mock
    private lateinit var catRepository: CatRepository
    private lateinit var getCatListUseCase: GetCatListUseCase
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getCatListUseCase = GetCatListUseCase(catRepository)
    }

    @Test
    fun `invoke should emit loading and then success when data is fetched successfully`() = runTest {
        val catDtoList = MockCatDto.mockCatDto

        Mockito.`when`(catRepository.getListOfCatBreed()).thenReturn(catDtoList)

        val flow = getCatListUseCase()
        val result = flow.toList()

        val expectedCatModels = catDtoList.map { it.toCatModel() }
        val successResult = result[1] as Resource.Success<List<CatModel>>

        assertEquals(2, result.size)
        assertTrue(result[0] is Resource.Loading)
        assertEquals(expectedCatModels, successResult.data)
    }

    @Test
    fun `invoke should emit loading and then error when HttpException is thrown`() = runTest {
        val exception = HttpException(retrofit2.Response.error<String>(404, "".toResponseBody(null)))

        Mockito.`when`(catRepository.getListOfCatBreed()).thenThrow(exception)

        val flow = getCatListUseCase()
        val result = flow.toList()

        val errorResult = result[1] as Resource.Error<List<CatModel>>

        assertEquals(2, result.size)
        assertTrue(result[0] is Resource.Loading)
        assertEquals("HTTP 404 Response.error()", errorResult.message)
    }

    @Test
    fun `invoke should emit loading and then error when IOException is thrown`() = runTest {
        val exception = IOException()

        runBlocking {
            Mockito.`when`(catRepository.getListOfCatBreed()).thenAnswer { throw exception }
        }

        val flow = getCatListUseCase()
        val result = flow.toList()

        val errorResult = result[1] as Resource.Error<List<CatModel>>

        assertEquals(2, result.size)
        assertTrue(result[0] is Resource.Loading)
        assertEquals("Error fetching data, check your network...", errorResult.message)
    }
}
