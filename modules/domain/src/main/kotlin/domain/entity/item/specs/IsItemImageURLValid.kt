package domain.entity.item.specs

import domain.entity.item.Item
import domain.validation.ISpecification
import java.net.MalformedURLException
import java.net.URISyntaxException
import java.net.URL

class IsItemImageURLValid() {
    companion object : ISpecification<Item> {

        override fun isSatisfiedBy(entity: Item): Boolean {
            return try {
                URL(entity.imageUrl).toURI()
                true
            } catch (e: MalformedURLException){
                false
            } catch (e: URISyntaxException){
                false
            }
        }

        override val failureMessage: String = "The provided image URL is not valid"
    }
}