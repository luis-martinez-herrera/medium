package com.example.opentelemetry.primary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenTelemetryPrimaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenTelemetryPrimaryApplication.class, args);
	}

}

