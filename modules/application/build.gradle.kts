group = "casestudy1.application"
version = "0.0.1"

repositories {
    mavenCentral() 
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
}

dependencies {
    implementation(project(":domain"))
}