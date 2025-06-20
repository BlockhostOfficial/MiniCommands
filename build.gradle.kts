plugins {
    java
    id("xyz.jpenilla.run-velocity") version "2.3.1"
}

group = "net.blockhost"
version = "1.0.1"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc"
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly("com.velocitypowered:velocity-api:3.1.1")
    annotationProcessor("com.velocitypowered:velocity-api:3.1.1")

    compileOnly("net.kyori:adventure-text-minimessage:4.23.0")
    compileOnly("io.github.miniplaceholders:miniplaceholders-api:2.3.0")

    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
}

tasks {
    runVelocity {
        velocityVersion("3.2.0-SNAPSHOT")
    }
}
