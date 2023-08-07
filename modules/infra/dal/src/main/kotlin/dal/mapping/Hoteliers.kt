package dal.mapping

import dal.mapping.Items.primaryKey
import domain.entity.Hotelier
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int

object Hoteliers: BaseTable<Hotelier>("t_hotelier") {
    val id = int("id").primaryKey()

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): Hotelier {
        return Hotelier(
            row[id] ?: 0
        )
    }
}