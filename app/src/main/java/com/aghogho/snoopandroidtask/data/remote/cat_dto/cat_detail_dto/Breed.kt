package com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto

import com.aghogho.snoopandroidtask.data.remote.cat_dto.Weight
import com.google.gson.annotations.SerializedName

data class Breed(
    val id: String,
    val name: String,
    val weight: Weight,
    val temperament: String,
    val origin: String,
    val description: String,
    @SerializedName("life_span")
    val lifeSpan: String,
    val adaptability: Int,
    @SerializedName("child_friendly")
    val childFriendly: Int,
    @SerializedName("dog_friendly")
    val dogFriendly: Int,
    @SerializedName("energy_level")
    val energyLevel: Int,
    val grooming: Int,
    @SerializedName("health_issues")
    val healthIssues: Int,
    val intelligence: Int,
    @SerializedName("shedding_level")
    val sheddingLevel: Int,
    @SerializedName("social_needs")
    val socialNeeds: Int,
    @SerializedName("stranger_friendly")
    val strangerFriendly: Int,
    val vocalisation: Int,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String
)
