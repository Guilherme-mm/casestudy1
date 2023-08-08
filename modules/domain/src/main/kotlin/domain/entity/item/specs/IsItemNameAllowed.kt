package domain.entity.item.specs

import domain.entity.item.Item
import domain.validation.ISpecification
import domain.validation.Notification

class IsItemNameAllowed() {
    companion object  : ISpecification<Item> {
        private val forbiddenNameTerms: List<String> = listOf("Free", "Offer", "Book", "Website")
        override val failureMessage: String = "Item name contains forbidden words"

        override fun isSatisfiedBy(entity: Item): Boolean {
            for (forbiddenName in forbiddenNameTerms) {
                if(entity.name.contains(forbiddenName, true))
                    return false
            }

            return true
        }
    }
}