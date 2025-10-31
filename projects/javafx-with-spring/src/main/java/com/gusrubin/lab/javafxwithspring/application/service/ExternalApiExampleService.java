package com.gusrubin.lab.javafxwithspring.application.service;

import com.gusrubin.lab.javafxwithspring.application.port.in.ExternalApiExampleUseCase;
import com.gusrubin.lab.javafxwithspring.application.port.out.ExternalApiPort;
import com.gusrubin.lab.javafxwithspring.domain.callexternalapi.ExampleResource;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Gustavo Rubin
 */
@Service
@RequiredArgsConstructor
public class ExternalApiExampleService implements ExternalApiExampleUseCase {

  private final ExternalApiPort externalApiPort;

  @Override
  public List<ExampleResource> getAll() {
    return externalApiPort.getAll();
  }

  @Override
  public ExampleResource getById(Long id) {
    return null;
  }
}
