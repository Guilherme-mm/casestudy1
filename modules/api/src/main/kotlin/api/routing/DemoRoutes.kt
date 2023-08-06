package api.routing

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Route.demoRouting() {
    route("/demo") {
        get {
            call.respondText("Demonstration endpoint", status = HttpStatusCode.OK)
        }
    }
}