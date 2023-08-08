package api.exception

import application.exception.CustomException

class ResourceNotFoundException(override val instance: String, override val message: String?,
                                override val cause: Throwable? = null): CustomException() {
    override val title: String = "Requested Resource Not Found"
    override val errorTypeURI = "/errors/server/resource-not-found"
}