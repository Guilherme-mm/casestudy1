package application.exception

class InvalidParameterException(override val instance: String, override val message: String?,
                                override val cause: Throwable? = null) : CustomException(message, cause) {
    override val title: String = "Invalid Parameter Received By The Application"
    override val errorTypeURI = "/errors/client/invalid-parameter-provided"
}