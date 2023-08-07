package application.item

import application.hotelier.HotelierDTO
import application.mapping.IModelMapper
import domain.entity.Item


data class ItemDTO (
    val id: Int,
    val name: String,
    val category: String,
    val imageUrl: String,
    val reputation: Int,
    val reputationBadge: String,
    val availability: Int,
    val hotelier: HotelierDTO
){
    companion object: IModelMapper<ItemDTO, Item> {
        override fun fromEntity(entity: Item): ItemDTO {
            return ItemDTO(
                entity.id,
                entity.name,
                entity.category.name,
                entity.imageUrl,
                entity.reputation,
                entity.reputationBadge.name,
                entity.availability,
                HotelierDTO.fromEntity(entity.hotelier)
            )
        }

        override fun toEntity(dto: ItemDTO): Item {
            TODO("Not yet implemented")
        }

        override fun fromEntity(entityList: List<Item>): MutableList<ItemDTO> {
            val dtoList: MutableList<ItemDTO> = ArrayList()

            for (entity in entityList) {
                dtoList.add(ItemDTO(
                    entity.id,
                    entity.name,
                    entity.category.name,
                    entity.imageUrl,
                    entity.reputation,
                    entity.reputationBadge.name,
                    entity.availability,
                    HotelierDTO.fromEntity(entity.hotelier)
                ))
            }

            return dtoList
        }

        override fun toEntity(dtoList: List<ItemDTO>): MutableList<Item> {
            TODO("Not yet implemented")
        }
    }
}