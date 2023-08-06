package application.item

import application.mapping.IModelMapper
import domain.entity.Item

data class ItemDTO (val id: Int){
    companion object: IModelMapper<ItemDTO, Item> {
        override fun fromEntity(entity: Item): ItemDTO {
            TODO("Not yet implemented")
        }

        override fun toEntity(dto: ItemDTO): Item {
            TODO("Not yet implemented")
        }

        override fun fromEntity(entityList: MutableList<Item>): MutableList<ItemDTO> {
            val dtoList: MutableList<ItemDTO> = ArrayList()

            for (entity in entityList) {
                dtoList.add(ItemDTO(entity.id))
            }

            return dtoList
        }

        override fun toEntity(dtoList: MutableList<ItemDTO>): MutableList<Item> {
            TODO("Not yet implemented")
        }
    }
}