package com.aghogho.snoopandroidtask.presentation.cat_list

import com.aghogho.snoopandroidtask.domain.model.CatModel

data class CatListState(
    val isLoading: Boolean = false,
    val catData: List<CatModel> = emptyList(),
    val error: String = ""
)
