package application.item

import domain.entity.*
import domain.entity.item.Item

interface IItemRepository {
    fun getItemsByHotelier(hotelier: Hotelier): List<Item>
    fun getItem(itemId: Int): Item?
    fun create(item: Item): Int
    fun update(itemId: Int, item: Item): Boolean
    fun delete(itemId: Int): Boolean
}