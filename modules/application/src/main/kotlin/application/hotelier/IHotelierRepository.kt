package application.hotelier

import domain.entity.hotelier.Hotelier

interface IHotelierRepository {
    fun getById(hotelierId: Int): Hotelier?
}