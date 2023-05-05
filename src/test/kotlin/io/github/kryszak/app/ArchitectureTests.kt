package io.github.kryszak.app

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AnalyzeClasses(packagesOf = [ArchitectureTests::class])
class ArchitectureTests {

    companion object {
        private val BASE_PACKAGE = ArchitectureTests::class.java.`package`.name

        private val DOMAIN_PACKAGE = "$BASE_PACKAGE.domain"
        private val ADAPTER_PACKAGE = "$BASE_PACKAGE.adapter"
        private val INFRASTRUCTURE_PACKAGE = "$BASE_PACKAGE.infrastructure"

        private const val SPRING_PACKAGE = "org.springframework"
    }

    @ArchTest
    val `there are no package cycles` =
        SlicesRuleDefinition.slices()
            .matching("$BASE_PACKAGE.(**)..")
            .should()
            .beFreeOfCycles()

    @ArchTest
    val `the domain does not access the infrastructure and adapters` =
        noClasses()
            .that()
            .resideInAPackage("$DOMAIN_PACKAGE..")
            .should()
            .accessClassesThat()
            .resideInAnyPackage("$INFRASTRUCTURE_PACKAGE..", "$ADAPTER_PACKAGE..")

    @ArchTest
    val `domain should not depend on framework` =
        noClasses()
            .that().resideInAPackage("$DOMAIN_PACKAGE..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("$SPRING_PACKAGE..")

    @ArchTest
    val `adapters should not access domain and infrastructure` =
        noClasses()
            .that()
            .resideInAPackage("$ADAPTER_PACKAGE..")
            .should()
            .accessClassesThat()
            .resideInAnyPackage("$INFRASTRUCTURE_PACKAGE..", "$DOMAIN_PACKAGE..")
}