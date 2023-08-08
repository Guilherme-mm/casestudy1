package dal.repository

import application.hotelier.IHotelierRepository
import dal.db.DatabaseContext
import dal.mapping.Hoteliers
import domain.entity.hotelier.Hotelier
import org.ktorm.dsl.*


class HotelierRepository(val dbContext: DatabaseContext) : IHotelierRepository {
    override fun getById(hotelierId: Int): Hotelier? {
        return dbContext.database
            .from(Hoteliers)
            .select()
            .where { (Hoteliers.id eq hotelierId) }
            .map { Hoteliers.createEntity(it) }
            .firstOrNull()
    }
}