package api.routing

import api.exception.MissingRouteParameterException
import api.exception.ResourceNotFoundException
import application.item.ItemDTO
import application.item.ItemService
import dal.db.DatabaseContext
import dal.repository.ItemRepository
import dal.repository.LocationRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.itemRouting(dbContext: DatabaseContext) {
    route("/items"){
        get("/{itemId}") {
            val itemsService = ItemService(ItemRepository(dbContext), LocationRepository(dbContext))

            val itemId: Int = call.parameters["itemId"]?.toInt() ?: throw MissingRouteParameterException(call.request.uri, "The required parameter <item id> could not be found on the request")
            val item = itemsService.getById(itemId)

            if(item != null) {
                call.response.status(HttpStatusCode.OK)
                call.respond(item)
            } else {
                throw ResourceNotFoundException(call.request.uri, "No item found using the provided item id")
            }
        }

        post {
            val item = call.receive<ItemDTO>()
            val itemsService = ItemService(ItemRepository(dbContext), LocationRepository(dbContext))

            itemsService.create(item)

            call.response.status(HttpStatusCode.Created)
            call.respondText("Item created with success")
        }

        put ("/{itemId}"){
            val item = call.receive<ItemDTO>()
            val itemId: Int = call.parameters["itemId"]?.toInt() ?: throw MissingRouteParameterException(call.request.uri, "The required parameter <item id> could not be found on the request")

            val itemsService = ItemService(ItemRepository(dbContext), LocationRepository(dbContext))

            val success = itemsService.update(itemId, item)

            if(success) {
                call.response.status(HttpStatusCode.OK)
                call.respondText("Item updated with success")
            } else {
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText("Something went wrong trying to update the requested item")
            }
        }

        delete ("/{itemId}") {
            val itemId: Int = call.parameters["itemId"]?.toInt() ?: throw MissingRouteParameterException(call.request.uri, "The required parameter <item id> could not be found on the request")
            val itemsService = ItemService(ItemRepository(dbContext), LocationRepository(dbContext))

            val success = itemsService.delete(itemId)

            if(success) {
                call.response.status(HttpStatusCode.OK)
                call.respondText("Item deleted with success")
            } else {
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText("Something went wrong trying to delete the requested item")
            }
        }

        post ("/book/{itemId}") {
            val itemId: Int = call.parameters["itemId"]?.toInt() ?: throw MissingRouteParameterException(call.request.uri, "The required parameter <item id> could not be found on the request")
            val itemsService = ItemService(ItemRepository(dbContext), LocationRepository(dbContext))

            val success = itemsService.bookItem(itemId)

            if(success) {
                call.response.status(HttpStatusCode.OK)
                call.respondText("Item booked with success")
            } else {
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText("Something went wrong trying to book the requested item")
            }
        }
    }
}