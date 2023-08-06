package api.exception

class MissingRouteParameterException(message: String? = null, cause: Throwable? = null): CustomException(message, cause) {
    override val title: String = "Missing Required Route Parameter"
    override val errorTypeURI = "/errors/client/missing-route-parameter"
}