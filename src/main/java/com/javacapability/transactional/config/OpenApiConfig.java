package com.javacapability.transactional.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Transactional Example",
        version = "0.0.1-SNAPSHOT",
        description = "Project to demonstrate the Transactional in a Spring-boot Application")
)
public class OpenApiConfig {
}