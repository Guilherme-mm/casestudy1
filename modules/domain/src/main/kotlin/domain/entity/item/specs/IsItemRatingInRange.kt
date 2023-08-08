package domain.entity.item.specs

import domain.entity.item.Item
import domain.validation.ISpecification
import domain.validation.Notification

class IsItemRatingInRange(){
    companion object : ISpecification<Item> {
        override fun isSatisfiedBy(entity: Item): Boolean {
            return (entity.rating in 0..5)
        }

        override val failureMessage: String = "The item rating must be a value between 0 and 5"
    }
}