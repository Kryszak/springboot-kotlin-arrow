package net.kryszak.wip.example

import io.kotest.assertions.arrow.core.shouldBeRight
import org.junit.jupiter.api.Test

class HelloWorldServiceTest {

    @Test
    fun shouldReturnProperValue() {
        //given
        val service = HelloWorldService()

        //when
        val result = service.hello()

        //then
        result.shouldBeRight("Hello, world!")
    }
}