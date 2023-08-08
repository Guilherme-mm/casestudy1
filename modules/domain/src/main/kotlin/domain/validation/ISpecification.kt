package domain.validation

interface ISpecification<T> {
    val failureMessage: String
    fun isSatisfiedBy(entity: T): Boolean
}