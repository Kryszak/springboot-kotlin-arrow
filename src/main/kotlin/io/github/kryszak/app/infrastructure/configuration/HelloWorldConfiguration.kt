package io.github.kryszak.app.infrastructure.configuration

import io.github.kryszak.app.adapter.ExampleHelloAdapter
import io.github.kryszak.app.domain.HelloAdapter
import io.github.kryszak.app.domain.HelloWorldService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloWorldConfiguration {

    @Bean
    fun helloAdapter(): HelloAdapter = ExampleHelloAdapter()

    @Bean
    fun helloWorldService(helloAdapter: HelloAdapter): HelloWorldService = HelloWorldService(helloAdapter)
}