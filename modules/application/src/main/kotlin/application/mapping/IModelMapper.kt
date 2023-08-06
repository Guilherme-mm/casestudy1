package application.mapping

interface IModelMapper <DTO, Entity>{
    fun fromEntity(entity: Entity): DTO
    fun toEntity(dto: DTO): Entity

    fun fromEntity(entityList: MutableList<Entity>): MutableList<DTO>
    fun toEntity(dtoList: MutableList<DTO>): MutableList<Entity>
}