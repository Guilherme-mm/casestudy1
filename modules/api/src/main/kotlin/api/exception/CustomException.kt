package api.exception

abstract class CustomException(message: String? = null, cause: Throwable? = null) : Exception(message, cause) {
    abstract val title: String?
    abstract val errorTypeURI: String
}