package net.kryszak.app.infrastructure.configuration

import net.kryszak.app.adapter.ExampleHelloAdapter
import net.kryszak.app.domain.HelloAdapter
import net.kryszak.app.domain.HelloWorldService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloWorldConfiguration {

    @Bean
    fun helloAdapter(): HelloAdapter = ExampleHelloAdapter()

    @Bean
    fun helloWorldService(helloAdapter: HelloAdapter): HelloWorldService = HelloWorldService(helloAdapter)
}