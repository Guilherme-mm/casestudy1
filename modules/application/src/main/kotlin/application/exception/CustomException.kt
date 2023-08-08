package application.exception

abstract class CustomException(message: String? = null, cause: Throwable? = null) : Exception(message, cause) {
    abstract val title: String?
    abstract val errorTypeURI: String
    abstract val instance: String
}