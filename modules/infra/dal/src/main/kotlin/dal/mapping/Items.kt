package dal.mapping

import dal.db.DatabaseContext
import dal.repository.HotelierRepository
import dal.repository.LocationRepository
import domain.entity.item.Item
import domain.entity.item.ItemCategory
import domain.entity.item.ReputationBadge
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.*

object Items : BaseTable<Item>("t_item"){
    val id = int("id").primaryKey()
    val name = varchar("name")
    val category = varchar("category")
    val imageUrl = varchar("image_url")
    val reputation = int("reputation")
    val availability = int("availability")
    val hotelierId = int("hotelier_id")
    val rating = int("rating")
    val price = int("price")
    val reputationBadge = varchar("reputation_badge")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): Item {
        var rowCategory = ItemCategory.HOTEL
        var rowReputationBadge = ReputationBadge.GREEN

        if(row[category] != null) {
            rowCategory = ItemCategory.valueOf(row[category]!!.uppercase())
        }

        val dbContext = DatabaseContext()
        val rowHotelier = HotelierRepository(dbContext).getById(row[hotelierId]!!)!!
        val rowLocation = LocationRepository(dbContext).getByItemId(row[id]!!)!!

        return Item(
        row[id] ?: 0,
            row[name] ?: "null",
            rowCategory,
            row[imageUrl] ?: "null",
            row[reputation] ?: 0,
            row[availability] ?: 0,
            rowHotelier,
            row[rating] ?: 0,
            row[price] ?: 0,
            rowLocation
        )
    }
}