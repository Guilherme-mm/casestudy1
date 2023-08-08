package application.location

import application.mapping.IModelMapper
import domain.entity.location.Location

class LocationDTO(
    val id: Int?,
    val city: String,
    val state: String,
    val country: String,
    val zipCode: Int,
    val address: String
) {
    companion object: IModelMapper<LocationDTO, Location> {
        override fun fromEntity(entity: Location): LocationDTO {
            return LocationDTO(
                entity.id,
                entity.city,
                entity.state,
                entity.country,
                entity.zipCode,
                entity.address
            )
        }

        override fun toEntity(dto: LocationDTO): Location {
            return Location(
                dto.id,
                dto.city,
                dto.state,
                dto.country,
                dto.zipCode,
                dto.address
            )
        }

        override fun fromEntity(entityList: List<Location>): MutableList<LocationDTO> {
            TODO("Not yet implemented")
        }

        override fun toEntity(dtoList: List<LocationDTO>): MutableList<Location> {
            TODO("Not yet implemented")
        }
    }
}