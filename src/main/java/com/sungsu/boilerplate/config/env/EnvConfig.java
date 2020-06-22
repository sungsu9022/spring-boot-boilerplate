package com.sungsu.boilerplate.config.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@ConfigurationProperties(prefix = "env")
@Getter
public class EnvConfig {
	private String phase;

	public boolean isLocal() {
		return Phase.from(phase) == Phase.LOCAL;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}
}
