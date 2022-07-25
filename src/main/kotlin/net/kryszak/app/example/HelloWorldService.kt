package net.kryszak.app.example

import arrow.core.Either
import org.springframework.stereotype.Service

@Service
class HelloWorldService {

    fun hello(): Either<Exception, String> {
        return Either.Right("Hello, world!")
    }
}