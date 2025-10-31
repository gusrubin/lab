package com.gusrubin.lab.javafxwithspring.infrastructure.config;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MimeTypeUtils;

/**
 * @author Gustavo Rubin
 */
@Configuration
public class MockWebServerConfig {

  @Bean(initMethod = "start", destroyMethod = "stop")
  public WireMockServer wireMockServer() throws JsonProcessingException {
    WireMockServer server = new WireMockServer(8089);

    configureFor("localhost", 8089);

    record MessageResponseDto(Long id, String message) {}
    var responseSuccefull =
        List.of(
            new MessageResponseDto(1L, "Resposta 1"),
            new MessageResponseDto(2L, "Resposta 2"),
            new MessageResponseDto(3L, "Resposta 3"));
    String json = new ObjectMapper().writeValueAsString(responseSuccefull);

    server.stubFor(
        get("/messages")
            .willReturn(
                aResponse()
                    .withStatus(200)
                    .withHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .withBody(json)));

    return server;
  }
}
