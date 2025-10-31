package com.gusrubin.lab.javafxwithspring.infrastructure.config;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Gustavo Rubin
 */
@Configuration
public class WebClientConfig {

  private static final String API_EXAMPLE_BASE_URL = "http://localhost:8089";

  @Bean
  public WebClient webClientApiExample(WebClient.Builder builder) {
    return builder
        .baseUrl(API_EXAMPLE_BASE_URL)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
        .build();
  }
}
