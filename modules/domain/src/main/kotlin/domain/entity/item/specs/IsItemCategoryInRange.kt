package domain.entity.item.specs

import domain.entity.item.Item
import domain.entity.item.ItemCategory
import domain.validation.ISpecification
import domain.validation.Notification

class IsItemCategoryInRange() {
    companion object : ISpecification<Item>{
        override fun isSatisfiedBy(entity: Item): Boolean {
            return enumValues<ItemCategory>().any { it.name == entity.category.name }
        }

        override val failureMessage: String = "Provided item category is not a valid value"
    }
}