plugins {
    val kotlinVersion = "1.8.21"
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    jacoco
}

group = "io.github.kryszak"
version = "0.0.1-SNAPSHOT"

val kotestVersion = "5.6.1"
val kotestArrowExtensionVersion = "1.3.3"
val kotestSpringExtensionVersion = "1.1.2"
val mockkVersion = "1.13.5"
val arrowVersion = "1.1.5"
val archunitVersion = "1.0.1"

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("io.arrow-kt:arrow-core:$arrowVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest.extensions:kotest-assertions-arrow:$kotestArrowExtensionVersion")

    testImplementation("io.mockk:mockk:$mockkVersion")

    testImplementation("com.tngtech.archunit:archunit-junit5-api:$archunitVersion")
    testImplementation("com.tngtech.archunit:archunit-junit5-engine:$archunitVersion")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.withType<Jar>() {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

jacoco {
    toolVersion = "0.8.9"
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(false)
    }
}
