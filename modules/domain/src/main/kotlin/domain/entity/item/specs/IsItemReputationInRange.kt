package domain.entity.item.specs

import domain.entity.item.Item
import domain.validation.ISpecification
import domain.validation.Notification

class IsItemReputationInRange(){
    companion object : ISpecification<Item> {
        override fun isSatisfiedBy(entity: Item): Boolean {
            return (entity.reputation in 0..1000)
        }

        override val failureMessage: String = "The item reputation must be a value between 0 and 1000"
    }
}