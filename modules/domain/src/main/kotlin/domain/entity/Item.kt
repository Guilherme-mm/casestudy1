package domain.entity

class Item (
    val id: Int,
    val name: String,
    val category: ItemCategory,
    val imageUrl: String,
    val reputation: Int,
    val reputationBadge: ReputationBadge,
    val availability: Int,
    val hotelier: Hotelier
)