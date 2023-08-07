package dal.mapping

import dal.db.DatabaseContext
import dal.repository.HotelierRepository
import domain.entity.Item
import domain.entity.ItemCategory
import domain.entity.ReputationBadge
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.*

object Items : BaseTable<Item>("t_item"){
    val id = int("id").primaryKey()
    val name = varchar("name")
    val category = varchar("category")
    val imageUrl = varchar("image_url")
    val reputation = int("reputation")
    val reputationBadge= varchar("reputation_badge")
    val availability = int("availability")
    val hotelierId = int("hotelier_id")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): Item {
        var rowCategory = ItemCategory.HOTEL
        var rowReputationBadge = ReputationBadge.GREEN

        if(row[category] != null) {
            rowCategory = ItemCategory.valueOf(row[category]!!.uppercase())
        }

        if(row[reputationBadge] != null) {
            rowReputationBadge = ReputationBadge.valueOf(row[reputationBadge]!!.uppercase())
        }

        var rowHotelier = HotelierRepository(DatabaseContext()).getById(row[hotelierId]!!)!!

        return Item(
        row[id] ?: 0,
            row[name] ?: "null",
            rowCategory,
            row[imageUrl] ?: "null",
            row[reputation] ?: 0,
            rowReputationBadge,
            row[availability] ?: 0,
            rowHotelier
        )
    }
}