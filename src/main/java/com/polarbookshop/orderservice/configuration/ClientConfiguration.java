package com.polarbookshop.orderservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {

    @Bean
    WebClient webClient(ClientProperties clientProperties, WebClient.Builder webclientBuilder) {
        return WebClient.builder()
                .baseUrl(clientProperties.catalogServiceUri().toString())
                .build();
    }
}
