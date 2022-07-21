package net.kryszak.wip.example

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloWorldController(
    private val service: HelloWorldService
) {

    @GetMapping
    fun helloWorld(): ResponseEntity<String> =
        service.hello()
            .fold(
                { ResponseEntity.badRequest().build() },
                { res -> ResponseEntity.ok(res) }
            )
}