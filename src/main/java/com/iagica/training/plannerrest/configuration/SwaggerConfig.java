package com.iagica.training.plannerrest.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder().group("Api").pathsToMatch("/api/**").build();
    }

    @Bean
    public OpenAPI apiInfo() {
        final var securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")))
                .info(
                        new Info()
                                .title("DevPlanner Rest Api")
                                .description("Rest Api for DevPlanner web application")
                                .version("0.0.1"));
    }
}
