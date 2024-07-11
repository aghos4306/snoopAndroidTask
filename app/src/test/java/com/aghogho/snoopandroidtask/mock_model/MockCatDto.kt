package com.aghogho.snoopandroidtask.mock_model

import com.aghogho.snoopandroidtask.data.remote.cat_dto.CatDto
import com.aghogho.snoopandroidtask.data.remote.cat_dto.Image
import com.aghogho.snoopandroidtask.data.remote.cat_dto.Weight

object MockCatDto {
    val mockCatDto = listOf(
        CatDto(
            id = "1",
            name = "Abyssinian",
            adaptability = 5,
            affectionLevel = 5,
            altNames = "Aby",
            cfaUrl = "https://www.cfa.org",
            childFriendly = 4,
            countryCode = "EG",
            countryCodes = "EG",
            description = "Abyssinian description",
            dogFriendly = 5,
            energyLevel = 5,
            experimental = 0,
            grooming = 1,
            hairless = 0,
            healthIssues = 2,
            hypoallergenic = 0,
            image = Image(
                id = "abcd",
                height = 1,
                url = "",
                width = 4
            ),
            indoor = 0,
            intelligence = 5,
            lap = 1,
            lifeSpan = "14 - 15",
            natural = 1,
            origin = "Egypt",
            rare = 0,
            referenceImageId = "123",
            rex = 0,
            sheddingLevel = 2,
            shortLegs = 0,
            socialNeeds = 5,
            strangerFriendly = 5,
            suppressedTail = 0,
            temperament = "Active, Energetic, Independent, Intelligent, Gentle",
            vcahoSpitalsUrl = "https://www.vcahospitals.com",
            vetStreetUrl = "https://www.vetstreet.com",
            vocalisation = 1,
            weight = Weight(
                imperial = "5ft",
                metric = "5cm"
            ),
            wikipediaUrl = "https://en.wikipedia.org/wiki/Abyssinian_(cat)"
        )
    )
}
