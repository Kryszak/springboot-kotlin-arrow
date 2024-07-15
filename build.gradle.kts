plugins {
    val kotlinVersion = "2.0.0"
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    jacoco
}

group = "io.github.kryszak"
version = "0.0.1-SNAPSHOT"

val kotestVersion = "5.9.1"
val kotestArrowExtensionVersion = "1.4.0"
val kotestSpringExtensionVersion = "1.3.0"
val mockkVersion = "1.13.12"
val arrowVersion = "1.2.4"
val archunitVersion = "1.3.0"

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
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
    testImplementation("io.kotest.extensions:kotest-extensions-spring:$kotestSpringExtensionVersion")
    testImplementation("io.kotest.extensions:kotest-assertions-arrow:$kotestArrowExtensionVersion")

    testImplementation("io.mockk:mockk:$mockkVersion")

    testImplementation("com.tngtech.archunit:archunit-junit5-api:$archunitVersion")
    testImplementation("com.tngtech.archunit:archunit-junit5-engine:$archunitVersion")
}

tasks {
    test {
        useJUnitPlatform()
        finalizedBy(jacocoTestReport)
    }
    withType<Jar>() {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    jacocoTestReport {
        dependsOn(test)
        reports {
            xml.required.set(true)
            html.required.set(false)
        }
    }
}

jacoco {
    toolVersion = "0.8.9"
}
