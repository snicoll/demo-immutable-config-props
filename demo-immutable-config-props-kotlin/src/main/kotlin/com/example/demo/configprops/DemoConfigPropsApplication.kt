package com.example.demo.configprops

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@ConfigurationPropertiesScan
class DemoImmutableConfigPropsKotlinApplication {

    @Bean
    fun acmePropertiesLogger(properties: AcmeProperties) = ApplicationRunner {
        println(""" 
            ****************************************
            timeout: ${properties.timeout}
            buffer size: ${properties.bufferSize}
            security username: ${properties.security.username}
            security password: ${properties.security.password}
            security roles: ${properties.security.roles}
            ****************************************""".trimIndent())
    }

}

fun main(args: Array<String>) {
    runApplication<DemoImmutableConfigPropsKotlinApplication>(*args)
}
