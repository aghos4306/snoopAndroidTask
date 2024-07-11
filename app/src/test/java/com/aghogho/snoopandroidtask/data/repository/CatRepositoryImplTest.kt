package com.aghogho.snoopandroidtask.data.repository

import com.aghogho.snoopandroidtask.data.remote.CatApiService
import com.aghogho.snoopandroidtask.mock_model.MockCatDetailDto
import com.aghogho.snoopandroidtask.mock_model.MockCatDto
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CatRepositoryImplTest {
    @Mock
    private lateinit var catApiService: CatApiService
    private lateinit var catRepositoryImpl: CatRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        catRepositoryImpl = CatRepositoryImpl(catApiService)
    }
    @Test
    fun `getListOfCatBreed() should fetch list of cat data from API`() = runTest {
        val catDtoList = MockCatDto.mockCatDto
        Mockito.`when`(catApiService.getListOfCatBreed()).thenReturn(catDtoList)

        val result = catRepositoryImpl.getListOfCatBreed()

        assertEquals(catDtoList, result)
        Mockito.verify(catApiService).getListOfCatBreed()
    }

    @Test
    fun `getCatDetailedInfo() should fetch detailed specific cat data from API`() = runTest {
        val catDetailDto = MockCatDetailDto.mockCatDetailDto
        val id = "abcd"
        val result = catRepositoryImpl.getCatDetailedInfo(id)

        Mockito.`when`(catApiService.getCatDetailedInfo(id)).thenReturn(catDetailDto)

        assertEquals(catDetailDto, result)
        Mockito.verify(catApiService).getCatDetailedInfo(id)
    }

}
