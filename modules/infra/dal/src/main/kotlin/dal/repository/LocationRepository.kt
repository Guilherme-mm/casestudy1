package dal.repository

import application.location.ILocationRepository
import dal.db.DatabaseContext
import dal.mapping.Hoteliers
import dal.mapping.Items
import dal.mapping.Locations
import domain.entity.item.Item
import domain.entity.location.Location
import org.ktorm.dsl.*

class LocationRepository(val dbContext: DatabaseContext) : ILocationRepository {
    override fun getByItemId(itemId: Int): Location? {
        return dbContext.database
            .from(Locations)
            .select()
            .where { (Locations.itemId eq itemId) }
            .map { Locations.createEntity(it) }
            .firstOrNull()
    }

    override fun create(itemId: Int, location: Location): Int {
        return dbContext.database.insert(Locations) {
            set(it.itemId, itemId)
            set(it.city, location.city)
            set(it.address, location.address)
            set(it.state, location.state)
            set(it.zipCode, location.zipCode)
            set(it.country, location.country)
        }
    }
}