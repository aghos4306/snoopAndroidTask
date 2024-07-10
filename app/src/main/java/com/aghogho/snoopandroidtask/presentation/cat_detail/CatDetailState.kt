package com.aghogho.snoopandroidtask.presentation.cat_detail

import com.aghogho.snoopandroidtask.domain.model.CatDetailModel

data class CatDetailState(
    val isLoading: Boolean = false,
    val catDetailData: CatDetailModel? = null,
    val error: String = ""
)
