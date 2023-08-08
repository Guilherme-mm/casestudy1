package api.routing

import dal.db.DatabaseContext
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val dbContext = DatabaseContext()

    routing {
        hotelierRouting(dbContext)
        itemRouting(dbContext)
    }
}