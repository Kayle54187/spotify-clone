package com.learning.spotifyclone.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:9000");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Christian");
        myContact.setEmail("habichristi@gmail.com");

        Info information = new Info()
                .title("Spotify Clone Backend API")
                .version("1.0")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
