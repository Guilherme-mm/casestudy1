package domain.entity.location.specs

import domain.entity.location.Location
import domain.validation.ISpecification
import kotlin.math.abs
import kotlin.math.log10

class IsZipCodeAtRequiredLength {
    companion object : ISpecification<Location> {
        override val failureMessage: String = "Location ZIP code must be 5 characters long"

        override fun isSatisfiedBy(entity: Location): Boolean {
            return (log10(abs(entity.zipCode.toDouble())).toInt() + 1) == 5
        }
    }
}