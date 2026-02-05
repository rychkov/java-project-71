plugins {
    id("com.github.ben-manes.versions") version "0.53.0"
    id("com.diffplug.spotless") version "8.1.0"
    id("org.sonarqube") version "7.1.0.6387"

    application
    checkstyle
    // jacoco
//    alias(libs.plugins.spotless)
//    alias(libs.plugins.lombok)
//    alias(libs.plugins.shadow)
//    alias(libs.plugins.sonarqube)
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
    gradlePluginPortal()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "rychkov_java-project-61")
        property("sonar.organization", "rychkov")
    }
}

checkstyle {
    toolVersion = "10.12.4"
}
