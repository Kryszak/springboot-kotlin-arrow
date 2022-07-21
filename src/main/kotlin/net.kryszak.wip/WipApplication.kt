package net.kryszak.wip

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WipApplication

fun main(args: Array<String>) {
    runApplication<WipApplication>(*args)
}