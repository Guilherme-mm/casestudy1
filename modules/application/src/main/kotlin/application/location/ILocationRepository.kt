package application.location

import domain.entity.item.Item
import domain.entity.location.Location

interface ILocationRepository {
    fun getByItemId(itemId: Int): Location?
    fun create(itemId: Int, location: Location): Int
    fun update(itemId: Int, location: Location): Boolean
    fun delete(itemId: Int): Boolean
}