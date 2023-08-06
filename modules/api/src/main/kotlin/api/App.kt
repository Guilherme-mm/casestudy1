package api

import api.exception.exceptionHandler
import api.routing.configureRouting
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*

class App

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
    configureRouting()
    install(ContentNegotiation) {
        jackson()
    }
    install(StatusPages) {
        exception<Throwable> {
            call, cause -> exceptionHandler(call, cause)
        }
    }
}