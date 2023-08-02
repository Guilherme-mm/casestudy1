repositories {
    mavenCentral() 
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.0" 

    application 
}

application {
    mainClass.set("casestudy1.api.AppKt") 
}

