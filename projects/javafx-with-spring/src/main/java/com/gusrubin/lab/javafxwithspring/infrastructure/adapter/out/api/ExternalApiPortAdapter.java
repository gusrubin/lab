package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.out.api;

import com.gusrubin.lab.javafxwithspring.application.port.out.ExternalApiPort;
import com.gusrubin.lab.javafxwithspring.domain.callexternalapi.ExampleResource;
import com.gusrubin.lab.javafxwithspring.infrastructure.webclient.externalapiexample.ApiExampleWebClient;
import com.gusrubin.lab.javafxwithspring.infrastructure.webclient.externalapiexample.MessageResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Gustavo Rubin
 */
@Component
@RequiredArgsConstructor
public class ExternalApiPortAdapter implements ExternalApiPort {

  private final ApiExampleWebClient apiExampleWebClient;

  @Override
  public List<ExampleResource> getAll() {
    return apiExampleWebClient.getMessages().stream().map(this::toExampleResource).toList();
  }

  @Override
  public ExampleResource getById(Long id) {
    return null;
  }

  private ExampleResource toExampleResource(MessageResponseDto messageResponseDto) {
    return ExampleResource.restore(messageResponseDto.id(), messageResponseDto.message());
  }
}
