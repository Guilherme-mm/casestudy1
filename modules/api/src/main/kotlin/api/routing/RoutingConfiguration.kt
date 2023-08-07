package api.routing

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        demoRouting()
        hotelierRouting()
        itemRouting()
    }
}