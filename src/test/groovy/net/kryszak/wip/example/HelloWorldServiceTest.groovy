package net.kryszak.wip.example

import spock.lang.Specification

class HelloWorldServiceTest extends Specification {

    def "Should return hello world"() {
        given:
        def service = new HelloWorldService()

        when:
        def result = service.hello()

        then:
        result.right
        result.orNull() == "Hello, world!"
    }
}