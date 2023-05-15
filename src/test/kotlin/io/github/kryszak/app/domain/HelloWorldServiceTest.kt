package io.github.kryszak.app.domain

import arrow.core.Either
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.ShouldSpec
import io.mockk.every
import io.mockk.mockk

class HelloWorldServiceTest : ShouldSpec({

    should("return expected value") {
        //given
        val adapter = mockk<HelloAdapter>()
        every { adapter.callAdapter() } returns Either.Right("Hello from adapter!")

        val service = HelloWorldService(adapter)

        //when
        val result = service.hello()

        //then
        result shouldBeRight "Hello from adapter! And service!"
    }
})