package application.hotelier

import application.mapping.IModelMapper
import domain.entity.Hotelier

class HotelierDTO (
    val id: Int
){
    companion object: IModelMapper<HotelierDTO, Hotelier> {
        override fun fromEntity(entity: Hotelier): HotelierDTO {
            return HotelierDTO(
                entity.id
            )
        }

        override fun toEntity(dto: HotelierDTO): Hotelier {
            return Hotelier(dto.id)
        }

        override fun fromEntity(entityList: List<Hotelier>): MutableList<HotelierDTO> {
            TODO("Not yet implemented")
        }

        override fun toEntity(dtoList: List<HotelierDTO>): MutableList<Hotelier> {
            TODO("Not yet implemented")
        }
    }
}