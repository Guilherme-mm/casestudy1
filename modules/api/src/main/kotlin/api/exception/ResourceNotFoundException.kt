package api.exception

class ResourceNotFoundException(message: String? = null, cause: Throwable? = null): CustomException(message, cause) {
    override val title: String = "Requested Resource Not Found"
    override val errorTypeURI = "/errors/server/resource-not-found"
}