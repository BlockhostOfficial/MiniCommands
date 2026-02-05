plugins {
    base
    java
    id("xyz.jpenilla.run-velocity") version "3.0.2"
    id("com.diffplug.spotless") version "8.2.1"
    id("net.ltgt.errorprone") version "5.0.0"
    id("com.github.spotbugs") version "6.4.8"
    id("org.openrewrite.rewrite") version "7.25.0"
}

tasks.named<UpdateDaemonJvm>("updateDaemonJvm") {
    languageVersion = JavaLanguageVersion.of(25)
}

spotless {
    java {
        trimTrailingWhitespace()
        leadingTabsToSpaces(2)
        endWithNewline()
    }
}

rewrite {
    activeRecipe("org.openrewrite.staticanalysis.CommonStaticAnalysis")
    activeRecipe("org.openrewrite.staticanalysis.CodeCleanup")
    activeRecipe("org.openrewrite.staticanalysis.JavaApiBestPractices")
    activeRecipe("org.openrewrite.java.migrate.UpgradeToJava25")
    isExportDatatables = true
}

spotbugs {
    ignoreFailures = true
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
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    errorprone("com.google.errorprone:error_prone_core:2.47.0")
    spotbugs("com.github.spotbugs:spotbugs:4.9.8")

    rewrite("org.openrewrite.recipe:rewrite-static-analysis:2.26.0")
    rewrite("org.openrewrite.recipe:rewrite-migrate-java:3.26.0")
    rewrite("org.openrewrite.recipe:rewrite-rewrite:0.19.0")

    compileOnly("com.velocitypowered:velocity-api:3.4.0")
    annotationProcessor("com.velocitypowered:velocity-api:3.4.0")

    compileOnly("net.kyori:adventure-text-minimessage:4.26.1")
    compileOnly("io.github.miniplaceholders:miniplaceholders-api:3.1.0")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
}

tasks {
    runVelocity {
        velocityVersion("3.2.0-SNAPSHOT")
    }
}
