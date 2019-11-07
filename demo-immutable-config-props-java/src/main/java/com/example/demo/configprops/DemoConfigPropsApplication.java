package com.example.demo.configprops;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(AcmeProperties.class)
public class DemoConfigPropsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigPropsApplication.class, args);
	}

	@Bean
	public ApplicationRunner acmePropertiesLogger(AcmeProperties properties) {
		return (arguments) -> {
			System.out.println("****************************************");
			System.out.println("timeout: " + properties.getTimeout());
			System.out.println("buffer size: " + properties.getBufferSize());
			System.out.println("security username: " + properties.getSecurity().getUsername());
			System.out.println("security password: " + properties.getSecurity().getPassword());
			System.out.println("security roles: " + properties.getSecurity().getRoles());
			System.out.println("****************************************");
		};
	}

}
