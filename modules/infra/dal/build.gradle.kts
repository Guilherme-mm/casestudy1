group = "casestudy1.infra.dal"
version = "0.0.1"

repositories {
    mavenCentral()
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
}

dependencies {
    implementation(project(":application"))
    implementation(project(":domain"))

    implementation("org.ktorm:ktorm-core:3.6.0")
    implementation("org.ktorm:ktorm-support-postgresql:3.6.0")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.flywaydb:flyway-core:9.21.1")
}