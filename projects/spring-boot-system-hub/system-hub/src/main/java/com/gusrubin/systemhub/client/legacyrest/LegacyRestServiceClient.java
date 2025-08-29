package com.gusrubin.systemhub.client.legacyrest;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author Gustavo Rubin
 */
@Component
public class LegacyRestServiceClient {

  private final WebClient webClient;

  private static final String LEGACY_REST_SERVICE_BASE_URL = "http://localhost:8081";

  public LegacyRestServiceClient() {
    this.webClient = WebClient.builder().baseUrl(LEGACY_REST_SERVICE_BASE_URL).build();
  }

  public Flux<UserResponseDto> getUsers() {
    return webClient.get().uri("/api/v1/users").retrieve().bodyToFlux(UserResponseDto.class);
  }
}
