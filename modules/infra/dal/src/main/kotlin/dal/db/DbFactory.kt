package dal.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.ktorm.database.Database


class DbFactory (){
    private val dataSource by lazy {
        val config = HikariConfig()
        config.setJdbcUrl("jdbc:postgresql://relational_db:5432/casestudy1")
        config.username = "postgres"
        config.password = "admin"

        HikariDataSource(config)
    }

    private val database by lazy {
        Database.connect( dataSource )
            .also {
                flyway.migrate()
            }
    }

    private val flyway: Flyway by lazy {
        Flyway
            .configure()
            .dataSource(dataSource)
            .load()
    }

    fun getDbInstance():Database {
        return database
    }
}