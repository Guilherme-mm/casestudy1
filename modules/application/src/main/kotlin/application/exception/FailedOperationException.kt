package application.exception

class FailedOperationException(override val instance: String, override val message: String?,
                               override val cause: Throwable? = null) : CustomException(message, cause) {

    override val title: String = "The Requested Operation Could Not Be Done"
    override val errorTypeURI = "/errors/server/operation-failed"
}