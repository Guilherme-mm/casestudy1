package application.hotelier

import domain.entity.Hotelier
import domain.entity.Item

interface IHotelierRepository {
    fun getById(hotelierId: Int): Hotelier?
}