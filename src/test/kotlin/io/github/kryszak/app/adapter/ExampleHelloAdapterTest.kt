package io.github.kryszak.app.adapter

import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.ShouldSpec

internal class ExampleHelloAdapterTest : ShouldSpec({ 

    should("Return expected value") {
        //given
        val adapter = ExampleHelloAdapter()

        //when
        val result = adapter.callAdapter()

        //then
        result shouldBeRight "Hello from the adapter!"
    }
})