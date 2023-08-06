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
}