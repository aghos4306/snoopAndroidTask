package com.aghogho.snoopandroidtask.data.remote.cat_dto

import com.aghogho.snoopandroidtask.domain.model.CatModel
import com.google.gson.annotations.SerializedName

data class CatDto(
    val id: String,
    val adaptability: Int,
    @SerializedName("affection_level")
    val affectionLevel: Int,
    @SerializedName("alt_names")
    val altNames: String,
    @SerializedName("cfa_url")
    val cfaUrl: String,
    @SerializedName("child_friendly")
    val childFriendly: Int,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("country_codes")
    val countryCodes: String,
    val description: String,
    @SerializedName("dog_friendly")
    val dogFriendly: Int,
    @SerializedName("energy_level")
    val energyLevel: Int,
    val experimental: Int,
    val grooming: Int,
    val hairless: Int,
    @SerializedName("health_issues")
    val healthIssues: Int,
    val hypoallergenic: Int,
    val image: Image,
    val indoor: Int,
    val intelligence: Int,
    val lap: Int,
    @SerializedName("life_span")
    val lifeSpan: String,
    val name: String,
    val natural: Int,
    val origin: String,
    val rare: Int,
    @SerializedName("reference_image_id")
    val referenceImageId: String,
    val rex: Int,
    @SerializedName("shedding_level")
    val sheddingLevel: Int,
    @SerializedName("short_legs")
    val shortLegs: Int,
    @SerializedName("social_needs")
    val socialNeeds: Int,
    @SerializedName("stranger_friendly")
    val strangerFriendly: Int,
    @SerializedName("suppressed_tail")
    val suppressedTail: Int,
    val temperament: String,
    @SerializedName("vcahospitals_url")
    val vcahoSpitalsUrl: String,
    @SerializedName("vetstreet_url")
    val vetStreetUrl: String,
    val vocalisation: Int,
    val weight: Weight,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String
)

fun CatDto.toCatModel(): CatModel {
    return CatModel(
        id = id,
        image = image,
        name = name,
        origin = origin,
        referenceImageId = referenceImageId,
        isFavourited = false
    )
}
