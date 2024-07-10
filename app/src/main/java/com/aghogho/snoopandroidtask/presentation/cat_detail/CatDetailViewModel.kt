package com.aghogho.snoopandroidtask.presentation.cat_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aghogho.snoopandroidtask.domain.usecases.cat_detail.GetCatDetailedInfoUseCase
import com.aghogho.snoopandroidtask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatDetailViewModel @Inject constructor(
    private val getCatDetailedInfoUseCase: GetCatDetailedInfoUseCase
): ViewModel() {

    private val _catDetailState = mutableStateOf(CatDetailState())
    val catDetailState: State<CatDetailState> = _catDetailState
    fun getCatDetailInfo(id: String) {
        Log.d("CatDetailViewModel", "Fetching details for cat with id: $id")
        getCatDetailedInfoUseCase(id).onEach { catDetailResult ->
            when(catDetailResult) {
                is Resource.Loading -> {
                    _catDetailState.value = CatDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _catDetailState.value = CatDetailState(catDetailData = catDetailResult.data)
                }
                is Resource.Error -> {
                    Log.e("CatDetailViewModel", "Error fetching details: ${catDetailResult.message}")
                    _catDetailState.value = CatDetailState(error = catDetailResult.message ?: "An unexpected error occurred...")
                }
            }
        }.launchIn(viewModelScope)
    }
}
