package com.aghogho.snoopandroidtask.presentation.cat_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aghogho.snoopandroidtask.domain.usecases.cat_list.GetCatListUseCase
import com.aghogho.snoopandroidtask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatListViewModel @Inject constructor(
    private val getCatListUseCase: GetCatListUseCase
): ViewModel() {
    private val _catState = mutableStateOf(CatListState())
    val catState: State<CatListState> = _catState

    init {
        getCatList()
    }

    private fun getCatList() {
        getCatListUseCase().onEach {
            when(it) {
                is Resource.Loading -> {
                    _catState.value = CatListState(isLoading = true)
                }
                is Resource.Success -> {
                    _catState.value = CatListState(catData = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _catState.value = CatListState(error = it.message ?: "Detecting cause of error...")
                }
            }
        }.launchIn(viewModelScope)
    }
}
