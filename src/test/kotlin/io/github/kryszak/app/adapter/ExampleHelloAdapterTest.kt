package io.github.kryszak.app.adapter

import io.kotest.assertions.arrow.core.shouldBeRight
import org.junit.jupiter.api.Test

internal class ExampleHelloAdapterTest {

    @Test
    fun `should return expected value`() {
        //given
        val adapter = ExampleHelloAdapter()

        //when
        val result = adapter.callAdapter()

        //then
        result.shouldBeRight("Hello from the adapter!")
    }
}