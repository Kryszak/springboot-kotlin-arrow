package io.github.kryszak.app.adapter

import arrow.core.Either
import io.github.kryszak.app.domain.HelloAdapter

class ExampleHelloAdapter : HelloAdapter {
    override fun callAdapter(): Either<Exception, String> = Either.Right("Hello from the adapter!")
}