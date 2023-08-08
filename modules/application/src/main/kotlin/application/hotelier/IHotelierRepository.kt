package application.hotelier

import domain.entity.Hotelier

interface IHotelierRepository {
    fun getById(hotelierId: Int): Hotelier?
}