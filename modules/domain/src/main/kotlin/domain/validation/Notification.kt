package domain.validation

class Notification {
    private val elements: MutableList<NotificationElement> = mutableListOf<NotificationElement>()

    fun addError(title: String, message: String){
        elements.add(NotificationElement(title))
    }
}