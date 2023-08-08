package dal.mapping

import dal.mapping.Items.primaryKey
import domain.entity.item.Item
import domain.entity.location.Location
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Locations : BaseTable<Location>("t_location") {
    val id = int("id").primaryKey()
    val city = varchar("city")
    val state = varchar("state")
    val country = varchar("country")
    val zipCode = int("zip_code")
    val address = varchar("address")
    val itemId = int("item_id")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): Location {
        return Location(
            row[id] ?: 0,
            row[city] ?: "null",
            row[state] ?: "null",
            row[country] ?: "null",
            row[zipCode] ?: 0,
            row[address] ?: "0"
        )
    }
}