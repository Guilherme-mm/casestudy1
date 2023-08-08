package api.exception

import application.exception.CustomException

class MissingRouteParameterException(override val instance: String, override val message: String?,
                                     override val cause: Throwable? = null): CustomException() {
    override val title: String = "Missing Required Route Parameter"
    override val errorTypeURI = "/errors/client/missing-route-parameter"
}