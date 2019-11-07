package com.example.demo.configprops

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.util.unit.DataSize
import java.time.Duration

@ConfigurationProperties("acme")
@ConstructorBinding
data class AcmeProperties(val timeout: Duration = Duration.ofSeconds(10),
                          val bufferSize: DataSize?,
                          val security: Security) {

    data class Security(val username: String = "user",
                        val password: String,
                        val roles: List<String> = listOf("USER"))

}