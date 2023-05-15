package io.github.kryszak.app.infrastructure

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class BaseIntegrationTest : ShouldSpec() {
    override fun extensions() = listOf(SpringExtension)
}