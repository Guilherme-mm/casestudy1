package dal.db

import org.ktorm.database.Database

class DatabaseContext() {
    private val dbFactory: DbFactory = DbFactory()
    val database: Database = dbFactory.getDbInstance()
}