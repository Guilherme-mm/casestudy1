package application.item

import domain.entity.*

interface IItemRepository {
    fun getItemsByHotelier(hotelier: Hotelier): List<Item>
    fun getItem(itemId: Int): Item?
}