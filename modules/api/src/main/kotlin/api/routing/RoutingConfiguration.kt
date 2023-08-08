package api.routing

import dal.db.DatabaseContext
import io.ktor.server.application.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val dbContext = DatabaseContext()

    routing {
        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")
        openAPI(path="openapi", swaggerFile = "openapi/documentation.yaml")
        hotelierRouting(dbContext)
        itemRouting(dbContext)
    }
}