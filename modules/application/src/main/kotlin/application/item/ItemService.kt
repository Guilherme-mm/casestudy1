package application.item

import domain.entity.Hotelier

class ItemService (private val itemRepository: IItemRepository){

    fun getItemsByHotelierId(hotelierId:Int):MutableList<ItemDTO> {
        val hotelier = Hotelier(hotelierId)

        return ItemDTO.fromEntity(itemRepository.getItemsByHotelier(hotelier))
    }
}