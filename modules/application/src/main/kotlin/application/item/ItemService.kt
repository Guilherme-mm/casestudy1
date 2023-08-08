package application.item

import application.exception.FailedOperationException
import application.exception.InvalidParameterException
import application.location.ILocationRepository
import com.google.gson.Gson
import domain.entity.hotelier.Hotelier
import domain.entity.item.exception.NoRoomAvailableException
import java.lang.IllegalArgumentException

class ItemService (private val itemRepository: IItemRepository, private val locationRepository: ILocationRepository){

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

    fun create(item: ItemDTO): Int {
        try {
            val itemEntity = ItemDTO.toEntity(item)

            require(itemEntity.location != null) { "Required location attribute could not be found" }

            val insertedItemId = itemRepository.create(itemEntity)

            locationRepository.create(insertedItemId, itemEntity.location!!)
            return insertedItemId
        } catch (exc: IllegalArgumentException) {
            val gson = Gson()
            throw InvalidParameterException(gson.toJson(item), exc.message, exc)
        }
    }

    fun update(itemId: Int, item: ItemDTO): Boolean {
        try {
            val itemEntity = ItemDTO.toEntity(item)

            require(itemEntity.location != null) { "Required location attribute could not be found" }
            val itemResult =itemRepository.update(itemId, itemEntity)

            val locationResult = locationRepository.update(itemId, itemEntity.location!!)
            return itemResult && locationResult
        } catch (exc: IllegalArgumentException) {
            val gson = Gson()
            throw InvalidParameterException(gson.toJson(item), exc.message, exc)
        }
    }

    fun delete(itemId: Int): Boolean {
        val locationResult = locationRepository.delete(itemId)
        val itemResult = itemRepository.delete(itemId)

        return itemResult && locationResult
    }

    fun bookItem(itemId: Int): Boolean {
        val item = itemRepository.getItem(itemId)

        try {
            require(item != null) { "The requested item to book could not be found" }
            item.bookRoom()

            return itemRepository.update(itemId, item)
        } catch (exc: NoRoomAvailableException) {
            throw FailedOperationException( "Attempted item: ${itemId}", "The requested item has no available room to book", exc )
        }
        catch (exc: IllegalArgumentException) {
            throw InvalidParameterException("Attempted item: ${itemId}", exc.message, exc)
        }
    }
}