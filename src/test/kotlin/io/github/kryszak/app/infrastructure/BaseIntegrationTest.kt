package io.github.kryszak.app.infrastructure

import io.kotest.core.extensions.ApplyExtension
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@ApplyExtension(SpringExtension::class)
class BaseIntegrationTest : ShouldSpec() {
}