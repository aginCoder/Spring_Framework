package com.vti.kshop.configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "KShop REST APIs",
                description = "KShop REST APIs Documentation",
                termsOfService = "https://github.com/aginCoder/Spring_Framework/tree/kshop",
                contact = @Contact(
                        name = "Phạm Gia Ân",
                        url = "https://github.com/aginCoder",
                        email = "anpg25@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                version = "v1.0"
        ),
        servers = @Server(
                description = "Local ENV",
                url = "http://localhost:8080"
        ),
        externalDocs = @ExternalDocumentation(
                description = "KShop Github",
                url = "https://github.com/aginCoder/Spring_Framework/tree/kshop"
        )
)
public class OpenApiConfiguration {
}