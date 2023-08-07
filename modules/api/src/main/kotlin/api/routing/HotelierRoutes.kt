package api.routing

import api.exception.MissingRouteParameterException
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import application.item.*
import dal.db.DatabaseContext
import dal.db.DbFactory
import dal.repository.ItemRepository
import io.ktor.http.*

fun Route.hotelierRouting() {
    val dbContext = DatabaseContext()
    val itemsService = ItemService(ItemRepository(dbContext))

    route("/hoteliers"){
        get("/{hotelierId}/items") {
            val hotelierId: Int = call.parameters["hotelierId"]?.toInt() ?: throw MissingRouteParameterException("The required parameter <hotelier id> could not be found on the request")
            val itemsList: MutableList<ItemDTO> = itemsService.getItemsByHotelierId(hotelierId)

            call.response.status(HttpStatusCode.OK)
            call.respond(itemsList)
        }
    }
}