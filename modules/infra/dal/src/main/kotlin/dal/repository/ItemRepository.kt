package dal.repository

import application.item.IItemRepository
import domain.entity.Hotelier
import domain.entity.Item

class ItemRepository : IItemRepository {
    override fun getItemsByHotelier(hotelier: Hotelier): MutableList<Item> {
        return arrayListOf(Item(1), Item(2))
    }
}