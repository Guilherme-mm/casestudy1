package domain.entity.item

import domain.entity.hotelier.Hotelier
import domain.entity.item.exception.NoRoomAvailableException
import domain.entity.item.specs.*
import domain.entity.location.Location

class Item (
    var id: Int?,
    val name: String,
    val category: ItemCategory,
    val imageUrl: String,
    val reputation: Int,
    var availability: Int,
    val hotelier: Hotelier,
    val rating: Int,
    val price: Int,
    val location: Location?
) {
    val reputationBadge: ReputationBadge
    init {
        require(IsItemNameAllowed.isSatisfiedBy(this)) { IsItemNameAllowed.failureMessage + " - Received: <$name>" }
        require(IsItemNameAboveMinimumSize.isSatisfiedBy(this)) { IsItemNameAboveMinimumSize.failureMessage + " - Received: <$name>" }
        require(IsItemImageURLValid.isSatisfiedBy(this)) { IsItemImageURLValid.failureMessage + " - Received: <$imageUrl>" }
        require(IsItemRatingInRange.isSatisfiedBy(this)) { IsItemRatingInRange.failureMessage + " - Received: <$rating>" }
        require(IsItemCategoryInRange.isSatisfiedBy(this)) { IsItemCategoryInRange.failureMessage + " - Received: <${category.name}>" }
        require(IsItemReputationInRange.isSatisfiedBy(this)) { IsItemReputationInRange.failureMessage + " - Received: <$reputation>" }

        reputationBadge = calculateReputationBadge()
    }

    private fun calculateReputationBadge(): ReputationBadge{
        return when(reputation) {
            in 0 .. 500 -> { ReputationBadge.RED }
            in 501 .. 799 -> { ReputationBadge.YELLOW }
            else -> {
                ReputationBadge.GREEN
            }
        }
    }
    fun bookRoom() {
        if(availability > 0) --availability
        else throw NoRoomAvailableException()
    }
}