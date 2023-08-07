package dal.repository

import application.item.IItemRepository
import dal.db.DatabaseContext
import dal.mapping.Items
import domain.entity.Hotelier
import domain.entity.Item
import org.ktorm.dsl.*

class ItemRepository(val dbContext: DatabaseContext) : IItemRepository {
    override fun getItemsByHotelier(hotelier: Hotelier): List<Item> {
        return dbContext.database
            .from(Items)
            .select()
            .where { (Items.hotelierId eq hotelier.id) }
            .map { Items.createEntity(it) }
    }

    override fun getItem(itemId: Int): Item? {
        return dbContext.database
            .from(Items)
            .select()
            .where { (Items.id eq itemId) }
            .map { Items.createEntity(it) }
            .firstOrNull()
    }
}