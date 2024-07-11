package com.aghogho.snoopandroidtask.mock_model

import com.aghogho.snoopandroidtask.data.remote.cat_dto.Weight
import com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto.Breed
import com.aghogho.snoopandroidtask.data.remote.cat_dto.cat_detail_dto.CatDetailDto

object MockCatDetailDto {
    private val mockWeight = Weight(
        imperial = "7",
        metric = "3"
    )

    private val mockBreed = Breed(
        id = "abys",
        name = "Abyssinian",
        weight = mockWeight,
        temperament = "Active, Energetic, Independent, Intelligent, Gentle",
        origin = "Egypt",
        description = "The Abyssinian is easy to care for, and a joy to have in your home. They’re affectionate cats and love both people and other animals.",
        lifeSpan = "14 - 15",
        adaptability = 5,
        childFriendly = 3,
        dogFriendly = 4,
        energyLevel = 5,
        grooming = 1,
        healthIssues = 2,
        intelligence = 5,
        sheddingLevel = 2,
        socialNeeds = 5,
        strangerFriendly = 5,
        vocalisation = 1,
        wikipediaUrl = "https://en.wikipedia.org/wiki/Abyssinian_(cat)"
    )

    val mockCatDetailDto = CatDetailDto(
        id = "abcd",
        url = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
        width = 1200,
        height = 800,
        breeds = listOf(mockBreed)
    )
}
