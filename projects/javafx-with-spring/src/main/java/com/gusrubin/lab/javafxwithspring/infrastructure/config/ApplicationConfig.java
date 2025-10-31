package com.gusrubin.lab.javafxwithspring.infrastructure.config;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import java.util.List;
import javafx.scene.Node;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.InjectionPointLazyFxControllerAndViewResolver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MimeTypeUtils;

@Configuration
@EnableConfigurationProperties(ExternalServiceProperties.class)
public class ApplicationConfig {

  @Bean
  FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
    return new SpringFxWeaver(applicationContext);
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  <C, V extends Node> FxControllerAndView<C, V> controllerAndView(
      FxWeaver fxWeaver, InjectionPoint injectionPoint) {
    return new InjectionPointLazyFxControllerAndViewResolver(fxWeaver).resolve(injectionPoint);
  }

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
