package application.item

import domain.entity.Hotelier
import domain.entity.Item

class ItemService (private val itemRepository: IItemRepository){

    fun getItemsByHotelierId(hotelierId:Int):MutableList<ItemDTO> {
        val hotelier = Hotelier(hotelierId)

        return ItemDTO.fromEntity(itemRepository.getItemsByHotelier(hotelier))
    }

    fun getById(itemId: Int): ItemDTO? {
        val item = itemRepository.getItem(itemId)
        if(item != null) {
            return ItemDTO.fromEntity(itemRepository.getItem(itemId)!!)
        }

        return null
    }
}