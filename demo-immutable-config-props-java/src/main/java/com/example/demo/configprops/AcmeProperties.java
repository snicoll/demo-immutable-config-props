package com.example.demo.configprops;

import java.time.Duration;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.util.unit.DataSize;

@ConfigurationProperties("acme")
@ConstructorBinding
public class AcmeProperties {

	private final Duration timeout;

	private final DataSize bufferSize;

	private final Security security;

	public AcmeProperties(@DefaultValue("10s") Duration timeout, DataSize bufferSize, Security security) {
		this.timeout = timeout;
		this.bufferSize = bufferSize;
		this.security = security;
	}

	public Duration getTimeout() {
		return this.timeout;
	}

	public DataSize getBufferSize() {
		return this.bufferSize;
	}

	public Security getSecurity() {
		return this.security;
	}

	public static class Security {

		private final String username;

		private final String password;

		private final List<String> roles;

		public Security(@DefaultValue("user") String username, String password,
				@DefaultValue("USER") List<String> roles) {
			this.username = username;
			this.password = password;
			this.roles = roles;
		}

		public String getUsername() {
			return this.username;
		}

		public String getPassword() {
			return this.password;
		}

		public List<String> getRoles() {
			return this.roles;
		}
	}
}