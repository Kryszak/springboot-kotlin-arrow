package net.kryszak.app.domain

import arrow.core.Either

interface HelloAdapter {
    fun callAdapter(): Either<Exception, String>
}