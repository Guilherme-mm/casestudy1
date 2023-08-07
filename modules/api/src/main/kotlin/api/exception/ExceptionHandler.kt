package api.exception

import api.response.ProblemResponse
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.http.*
import io.ktor.server.request.*

suspend fun exceptionHandler (call: ApplicationCall, cause: Throwable) {
    when(cause) {
        is MissingRouteParameterException -> {
            val errorMessage = generateErrorMessage(cause, call.request.uri, HttpStatusCode.BadRequest.value)

            call.response.status(HttpStatusCode.BadRequest)
            call.respond(errorMessage)
        }
        is ResourceNotFoundException -> {
            val errorMessage = generateErrorMessage(cause, call.request.uri, HttpStatusCode.NotFound.value)

            call.response.status(HttpStatusCode.NotFound)
            call.respond(errorMessage)
        }
    }
}

fun generateErrorMessage( customException: CustomException, requestUri: String?, statusCode: Int?): ProblemResponse {
    return ProblemResponse(
        customException.errorTypeURI,
        customException.title,
        statusCode,
        customException.message,
        requestUri
    )
}