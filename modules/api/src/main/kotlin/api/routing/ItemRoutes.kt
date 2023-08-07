package api.routing

import api.exception.MissingRouteParameterException
import api.exception.ResourceNotFoundException
import application.item.ItemService
import dal.db.DatabaseContext
import dal.repository.ItemRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.itemRouting() {
    route("/items"){
        get("/{itemId}") {
            val dbContext = DatabaseContext()
            val itemsService = ItemService(ItemRepository(dbContext))

            val itemId: Int = call.parameters["itemId"]?.toInt() ?: throw MissingRouteParameterException("The required parameter <item id> could not be found on the request")
            val item = itemsService.getById(itemId)

            if(item != null) {
                call.response.status(HttpStatusCode.OK)
                call.respond(item)
            } else {
                throw ResourceNotFoundException("No item found using the provided item id")
            }
        }
    }
}