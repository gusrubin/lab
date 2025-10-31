package com.gusrubin.lab.javafxwithspring.infrastructure.webclient.externalapiexample;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.gusrubin.lab.javafxwithspring.infrastructure.config.ExternalServiceProperties;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Gustavo Rubin
 */
@Component
@RequiredArgsConstructor
public class ApiExampleWebClient {

  private final ExternalServiceProperties externalServiceProperties;
  private WebClient webClient;

  @PostConstruct
  void init() {
    webClient =
        WebClient.builder()
            .baseUrl(externalServiceProperties.baseUrl())
            .defaultHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
            .build();
  }

  public List<MessageResponseDto> getMessages() {
    return webClient
        .get()
        .uri("/messages")
        .retrieve()
        .bodyToFlux(MessageResponseDto.class)
        .collectList()
        .block();
  }
}
