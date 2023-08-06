package application.item

import domain.entity.*

interface IItemRepository {
    fun getItemsByHotelier(hotelier: Hotelier): MutableList<Item>
}