package api.routing

import api.exception.MissingRouteParameterException
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import application.item.*
import dal.db.DatabaseContext
import dal.db.DbFactory
import dal.repository.ItemRepository
import dal.repository.LocationRepository
import io.ktor.http.*
import io.ktor.server.request.*

fun Route.hotelierRouting(dbContext: DatabaseContext) {
    route("/hoteliers"){
        get("/{hotelierId}/items") {
            val itemsService = ItemService(ItemRepository(dbContext), LocationRepository(dbContext))

            val hotelierId: Int = call.parameters["hotelierId"]?.toInt() ?: throw MissingRouteParameterException(call.request.uri, "The required parameter <hotelier id> could not be found on the request")
            val itemsList: MutableList<ItemDTO> = itemsService.getItemsByHotelierId(hotelierId)

            call.response.status(HttpStatusCode.OK)
            call.respond(itemsList)
        }
    }
}