package io.github.kryszak.app.domain

import arrow.core.Either

class HelloWorldService(
    private val helloAdapter: HelloAdapter
) {
    fun hello(): Either<Exception, String> {
        return helloAdapter.callAdapter()
            .map { it.plus(" And service!") }
    }
}