package dal.repository

import application.item.IItemRepository
import dal.db.DatabaseContext
import dal.mapping.Items
import domain.entity.Hotelier
import domain.entity.item.Item
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

    override fun create(item: Item): Int {
        val result = dbContext.database.insertAndGenerateKey(Items) {
            set(it.name, item.name)
            set(it.rating, item.rating)
            set(it.category, item.category.name)
            set(it.imageUrl, item.imageUrl)
            set(it.reputation, item.reputation)
            set(it.reputationBadge, item.reputationBadge.name)
            set(it.price, item.price)
            set(it.availability, item.availability)
            set(it.hotelierId, item.hotelier.id)
        }

        return result as Int
    }

    override fun update(itemId: Int, item: Item): Boolean {
        val alteredRows = dbContext.database.update(Items) {
            set(it.name, item.name)
            set(it.rating, item.rating)
            set(it.category, item.category.name)
            set(it.imageUrl, item.imageUrl)
            set(it.reputation, item.reputation)
            set(it.reputationBadge, item.reputationBadge.name)
            set(it.price, item.price)
            set(it.availability, item.availability)
            set(it.hotelierId, item.hotelier.id)
            where { it.id eq itemId}
        }

        return alteredRows >= 1
    }
}