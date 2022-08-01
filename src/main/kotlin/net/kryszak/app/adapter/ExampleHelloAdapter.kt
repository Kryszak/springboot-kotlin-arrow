package net.kryszak.app.adapter

import arrow.core.Either
import net.kryszak.app.domain.HelloAdapter

class ExampleHelloAdapter : HelloAdapter {
    override fun callAdapter(): Either<Exception, String> = Either.Right("Hello from the adapter!")
}