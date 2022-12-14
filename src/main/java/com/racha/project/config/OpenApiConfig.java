package com.racha.project.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Futebol",
                version = "1.0",
                termsOfService = "Terms of service",
                contact = @Contact(
                        name = "Elyson Vinicius",
                        email = "elysonviniciusdev@outlook.com"
                )
        )
)
public class OpenApiConfig {
}