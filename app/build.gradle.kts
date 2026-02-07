import org.gradle.kotlin.dsl.annotationProcessor
import org.gradle.kotlin.dsl.implementation
import org.gradle.api.tasks.compile.JavaCompile


plugins {
    id("com.github.ben-manes.versions") version "0.53.0"
    id("com.diffplug.spotless") version "8.1.0"
    id("org.sonarqube") version "7.1.0.6387"

    application
    checkstyle
    `java-library`
     jacoco
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
        property("sonar.projectKey", "rychkov_java-project-71")
        property("sonar.organization", "rychkov")
    }
}

checkstyle {
    toolVersion = "10.12.4"
}

tasks.named<JavaCompile>("compileJava") {
    options.compilerArgs.add("-Aproject=${project.group}/${project.name}")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    implementation("info.picocli:picocli:4.7.7")
    annotationProcessor("info.picocli:picocli-codegen:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.21.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.21.0")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}