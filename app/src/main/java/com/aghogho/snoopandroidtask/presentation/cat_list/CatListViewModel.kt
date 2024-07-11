package com.aghogho.snoopandroidtask.presentation.cat_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aghogho.snoopandroidtask.data.local.shared_pref.PreferenceHelper
import com.aghogho.snoopandroidtask.domain.model.CatModel
import com.aghogho.snoopandroidtask.domain.usecases.cat_list.GetCatListUseCase
import com.aghogho.snoopandroidtask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatListViewModel @Inject constructor(
    private val getCatListUseCase: GetCatListUseCase,
    private val preferenceHelper: PreferenceHelper
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
                    val catsWithFavorites = it.data?.map {
                        it.withFavouriteStatus(preferenceHelper)
                    } ?: emptyList()
                    _catState.value = CatListState(catData = catsWithFavorites)
                }
                is Resource.Error -> {
                    _catState.value = CatListState(error = it.message ?: "Detecting cause of error...")
                }
            }
        }.launchIn(viewModelScope)
    }
    fun toggleFavourite(catModel: CatModel) {
        viewModelScope.launch {
            val newStatus = preferenceHelper.toggleFavoriteUsingPref(catModel.id)
            val updatedCat = catModel.copy(isFavourited = newStatus)
            _catState.value = _catState.value.copy(
                catData = _catState.value.catData.map {
                    if (it.id == catModel.id) updatedCat else it
                }
            )
        }
    }
}
