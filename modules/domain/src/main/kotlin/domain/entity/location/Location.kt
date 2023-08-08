package domain.entity.location

import domain.entity.location.specs.IsZipCodeAtRequiredLength

class Location(
    val id: Int?,
    val city: String,
    val state: String,
    val country: String,
    val zipCode: Int,
    val address: String
) {
    init {
        require(IsZipCodeAtRequiredLength.isSatisfiedBy(this)) { IsZipCodeAtRequiredLength.failureMessage + " - Receivec <$zipCode>" }
    }
}