package domain.entity.item

//import domain.entity.item.specs.*
//import domain.validation.And
//import domain.validation.Notification
//
//class ItemValidator {
//    fun fullyValidateItem(item: Item): Notification {
//        val notification = Notification()
//
//        val rule = IsItemNameAllowed(notification)
//            .And(IsItemNameAboveMinimumSize(notification))
//            .And(IsImageUriValid(notification))
//            .And(IsItemCategoryInRange(notification))
//            .And(IsItemRatingInRange(notification))
//            .And(IsItemLocationValid(notification))
//            .And(IsItemReputationInRange(notification))
//
//        rule.isSatisfiedBy(item)
//
//        return notification
//    }
//}