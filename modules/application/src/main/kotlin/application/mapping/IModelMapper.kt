package application.mapping

interface IModelMapper <DTO, Entity>{
    fun fromEntity(entity: Entity): DTO
    fun toEntity(dto: DTO): Entity

    fun fromEntity(entityList: List<Entity>): MutableList<DTO>
    fun toEntity(dtoList: List<DTO>): MutableList<Entity>
}