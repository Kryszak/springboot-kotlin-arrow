package io.github.kryszak.app.infrastructure

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.extensions.spring.SpringExtension

@SpringBootTest
@ActiveProfiles("test")
class BaseIntegrationTest : ShouldSpec() {
    override fun extensions() = listOf(SpringExtension)
}