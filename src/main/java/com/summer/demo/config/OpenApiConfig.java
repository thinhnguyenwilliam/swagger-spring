package com.summer.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://localhost:8081/summer/swagger-ui/index.html

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Add security requirement (which references the security scheme below)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                // Define components with security schemes
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                // API Info metadata
                .info(new Info()
                        .title("My App API")
                        .version("1.0.0")
                        .description("API documentation for Super, Pro, and VIP users.")
                        .contact(new Contact()
                                .name("Support Team")
                                .email("support@example.com")
                                .url("https://example.com/support"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
