package application.item

import application.hotelier.HotelierDTO
import application.location.LocationDTO
import application.mapping.IModelMapper
import domain.entity.item.Item
import domain.entity.item.ItemCategory
import domain.entity.item.ReputationBadge


data class ItemDTO (
    val id: Int?,
    val name: String,
    val category: String,
    val imageUrl: String,
    val reputation: Int,
    val reputationBadge: String?,
    val availability: Int,
    val hotelier: HotelierDTO,
    val rating: Int,
    val location: LocationDTO?,
    val price: Int
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
                HotelierDTO.fromEntity(entity.hotelier),
                entity.rating,
                entity.location?.let { LocationDTO.fromEntity(it) },
                entity.price
            )
        }

        override fun toEntity(dto: ItemDTO): Item {
            return Item(
                dto.id,
                dto.name,
                ItemCategory.valueOf(dto.category.uppercase()),
                dto.imageUrl,
                dto.reputation,
                dto.availability,
                HotelierDTO.toEntity(dto.hotelier),
                dto.rating,
                dto.price,
                dto.location?.let { LocationDTO.toEntity(it) }
            )
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
                    HotelierDTO.fromEntity(entity.hotelier),
                    entity.rating,
                    entity.location?.let { LocationDTO.fromEntity(it) },
                    entity.price
                ))
            }

            return dtoList
        }

        override fun toEntity(dtoList: List<ItemDTO>): MutableList<Item> {
            TODO("Not yet implemented")
        }
    }
}