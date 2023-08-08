package domain.entity.item.specs

import domain.entity.item.Item
import domain.validation.ISpecification

class IsItemNameAboveMinimumSize() {
    companion object : ISpecification<Item> {
        override val failureMessage: String = "Item name must be longer than 10 characters"

        override fun isSatisfiedBy(entity: Item): Boolean {
            return entity.name.length > 10
        }
    }
}